import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GameShow extends JPanel implements Runnable,MouseListener,KeyListener{
	
	Player p;
	ArrayList<Vehicle> arr;
	Thread runner;
	int count,c;
	int speed=5;
	boolean lose,win;
	static JFrame frame;
	
	public static void main(String[] args) {
		frame = new JFrame("App");
		frame.add(new GameShow());
		frame.setSize(1200,700);
		frame.setVisible(true);
	}
	
	public GameShow()
	{
		setBackground(Color.GREEN);
		p = new Player(50,300);
		
		arr = new ArrayList<Vehicle>();
		makeNewVehicle();
	
		frame.addMouseListener(this);
	}
	
	
	public void mouseClicked(MouseEvent e)
	{
		count++;
		if(count==2)
		{
			frame.addKeyListener(this);
			runner = new Thread(this);
			runner.start();
		}
	} 
 
	int x=0;
	public void run() 
	{
		while (!lose) 
		{
			x+=speed;
			if(x>=arr.get(arr.size()-1).getWidth()+50)
			{
				makeNewVehicle();
				x=0;
			}
			checkScreen();
			repaint();
			
			if(p.getY()<=-40||p.getY()>=600)
			{
				lose=true;
				repaint();
			}
			
			//this part pauses the method for 15 milliseconds so it appears the blocks are falling
			try { Thread.sleep(15); }
			catch (InterruptedException e) { }
		}
	}
	
	//repaints all the objects in the applet
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
	
		if(count<2)
		{
			g.drawString("Double click to start",500,100);
			g.drawString("Use W and S keys to move",500,120);
		}
	
		p.paint(g);
		
		for(int i=0;i<arr.size();i++)
		{
			arr.get(i).paint(g);
		}
		
		if(lose)
		{
			frame.removeKeyListener(this);
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER",500,100);
			g.drawString("You passed "+c+" vehicles",475,150);
		}
	}
	
	//this method sets the new position of the falling blocks
	//it also checks if the car intersects the falling blocks
	public void checkScreen()
	{
		for(int i=0;i<arr.size();i++)
		{
			arr.get(i).drive();
			
			if(p.crash(arr.get(i)))
			{
				lose = true;
				repaint();
			}
			
			if(arr.get(i).getX()<p.getX()-arr.get(i).getWidth())
			{
				arr.remove(i);
				i--;
				c++;
			}
		}
	}
	
	public void makeNewVehicle()
	{
		int rand = (int)(Math.random()*2);
		int y = (int)(Math.random()*650);
		Color color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		
		if(rand==0)
		{
			arr.add(new Car(1200,y,"",color,-speed));
		}
		if(rand==1)
		{
			arr.add(new Truck(1200+55,y,"",color,-speed));
		}
	}
	
	//moving the car object with keys
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			p.setLocation(p.getX(),p.getY()-10);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			p.setLocation(p.getX(),p.getY()+10);	
		}
		repaint();
	}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void mouseReleased(MouseEvent e){} 
	public void mousePressed(MouseEvent e){} 	
	public void mouseEntered(MouseEvent e){} 
	public void mouseExited(MouseEvent e){}

	
}