import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

public class GameShow extends JPanel{
	
	static JFrame frame;
	
	public static void main(String[] args) 
	{
		frame = new JFrame("App");
		frame.add(new GameShow());
		frame.setSize(1200,600);
		frame.setVisible(true);
	}

	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//Car a = new Car(50,50);
		
		AbstractCar b = new Car(150,50);
		b.paint(g2);
		b.printId(g);
		//b.sayHello(g);
		
		AbstractCar c = new CarWithStripe(150,150);
		c.paint(g2);
		c.printId(g);
		
		Car d = new Car(150,250);
		d.paint(g2);
		d.sayHello(g);
	}
	
}