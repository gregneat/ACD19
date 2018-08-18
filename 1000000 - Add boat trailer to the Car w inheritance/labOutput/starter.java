import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class starter extends JPanel
{
	static JFrame frame;
	
	Car redCar, redCarBoat;
	CarWithBoat blueCarBoat;

	public static void main(String[] args) {
		frame = new JFrame("App");
		frame.add(new starter());
		frame.setUndecorated(true);
		frame.setSize(600,600);
		frame.setVisible(true);
	}
	
	public starter()
	{
		Color a = new Color(0,255,0);
		setBackground(a);
		redCar = new Car(300,150,"Red Car",Color.RED,2);
		redCarBoat = new CarWithBoat(300,300,"Red Car with Boat",Color.RED,2);
		blueCarBoat = new CarWithBoat(300,450,"Blue Car with Boat",Color.BLUE,2);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		redCar.paint(g);
		redCarBoat.paint(g);
		blueCarBoat.paint(g);
	}
}

