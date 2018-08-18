import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class starter extends JPanel
{
	static JFrame frame;
	
	Car redCar;
	Rectangle2D.Double latch;
	Ellipse2D.Double wheel;
	Polygon base, window;

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
		redCar = new Car(300,200,"FERRARI",Color.RED,0.5);
		latch = new Rectangle2D.Double(220,207.5,120,5);
		base = new Polygon(new int[]{180,200,240,260}, new int[]{200,220,220,200},4);
		window = new Polygon(new int[]{200,230,240}, new int[]{200,180,200}, 3);
		wheel = new Ellipse2D.Double(212.5,220,15,15);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.fill(latch);
		g2.fill(wheel);
		g2.setColor(new Color(0,0,200));
		g2.fill(base);
		g2.setColor(Color.WHITE);
		g2.fill(window);
		redCar.paint(g);
	}
}

