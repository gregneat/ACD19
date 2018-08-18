import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class starter extends JPanel implements Runnable, MouseListener
{
	static JFrame frame;
	
	Vehicle[] vehicles;

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
		vehicles = new Vehicle[4];
		for(int i=0; i<vehicles.length; i++)
		{
			Color rand = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
			switch(i)
			{
				case 0:
					vehicles[i] = new Car(0, 20+200*i, "Car", rand, 2);
					break;
				case 1:
				case 3:
					vehicles[i] = new CarWithBoat(100, 20+200*i, "Car with Boat", rand, 2);
					break;
					case 2:
					vehicles[i] = new Truck(0, 200*i-20, "Truck", rand, 2);
					break;
			}
		}
		frame.addMouseListener(this);
		
		System.out.println("Click vehicles to start and stop them");
		Thread thread = new Thread(this);
		thread.start();//calls the run function
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(Vehicle item: vehicles)
			item.paint(g);
	}
	public void run()
	{
		while(true)
		{
			for(int i=0; i<vehicles.length; i++)
			{
				vehicles[i].drive();
				if(vehicles[i].getX() >= 600)
					vehicles[i].setLocation(0,vehicles[i].getY());
			}
			repaint();
			try { Thread.sleep(15); }
			catch (InterruptedException e) { }
		}
	}
	public void mousePressed(MouseEvent e)
	{
		for(int i = 0; i<vehicles.length;i++)
		{	
			if(vehicles[i].contains(e.getX(),e.getY()))
			{
				if(vehicles[i].getSpeed() == 0)
					vehicles[i].changeSpeed(2);
				else
					vehicles[i].changeSpeed(0);
			}
		}
	} 
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}  
	public void mouseEntered(MouseEvent e){} 
	public void mouseExited(MouseEvent e){}
}

