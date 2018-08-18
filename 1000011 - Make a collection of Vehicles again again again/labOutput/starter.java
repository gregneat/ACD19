import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.ArrayList;

public class starter extends JPanel implements Runnable, MouseListener
{
	static JFrame frame;
	
	ArrayList<Vehicle> vehicles;

	public static void main(String[] args) {
		frame = new JFrame("App");
		frame.add(new starter());
		frame.setUndecorated(true);
		frame.setSize(600,900);
		frame.setVisible(true);
		
	}
	
	public starter()
	{
		Color a = new Color(0,255,0);
		setBackground(a);
		vehicles = new ArrayList<Vehicle>();
		for(int i=0; i<4; i++)
		{
			Color rand = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
			switch(i)
			{
				case 0:
					vehicles.add(new Car(0, 20+200*i, "Car", rand, 2));
					break;
				case 1:
				case 3:
					vehicles.add(new CarWithBoat(100, 20+200*i, "Car with Boat", rand, 2));
					break;
					case 2:
					vehicles.add(new Truck(0, 200*i-20, "Truck", rand, 2));
					break;
			}
		}
		frame.addMouseListener(this);
		
		System.out.println("Click vehicles to stop then destroy (remove from arraylist)\n\nTraffic size: "+vehicles.size());
		Thread thread = new Thread(this);
		thread.start();//calls the run function
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(Vehicle item: vehicles)
			item.paint(g);
		
		g.setColor(Color.BLACK);
		g.drawString("Click on a vehicle to make it stop",100,300);
		g.drawString("Click on it again to remove it from memory",100,330);
	}
	public void run()
	{
		while(true)
		{
			for(int i=0; i<vehicles.size(); i++)
			{
				vehicles.get(i).drive();
				if(vehicles.get(i).getX() >= 600)
					vehicles.get(i).setLocation(0,vehicles.get(i).getY());
			}
			repaint();
			try { Thread.sleep(15); }
			catch (InterruptedException e) { }
		}
	}
	public void mousePressed(MouseEvent e)
	{
		for(int i = 0; i<vehicles.size();i++)
		{	
			if(vehicles.get(i).contains(e.getX(),e.getY()))
			{
				if(vehicles.get(i).getSpeed() == 0)
				{
					vehicles.remove(i);
					System.out.println("New traffic size: "+vehicles.size());
					break;
				}
				else
					vehicles.get(i).changeSpeed(0);
			}
		}
	} 
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}  
	public void mouseEntered(MouseEvent e){} 
	public void mouseExited(MouseEvent e){}
}

