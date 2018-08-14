import java.awt.geom.*;
import java.awt.*;

public class Car extends AbstractCar{

	public Car(int xx, int yy)
	{
		super(xx,yy);
	}
	
	// public void paint(Graphics2D g2)
	// {
		// super.paint(g2);
	// }
	
	public void printId(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawString("A regular car has been constructed",150,100);
	}
	
	public void sayHello(Graphics g)
	{
		g.drawString("Hello",150,300);
	}

	
}