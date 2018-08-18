import java.awt.geom.*;
import java.awt.*;

public class CarWithBoat extends Car{

	private Rectangle2D.Double latch;
	private Ellipse2D.Double wheel;
	private Polygon base, window;

	public CarWithBoat()
	{
		//super();
	}
	public CarWithBoat(String n)
	{
		super(n);
	}
	public CarWithBoat(double xx, double yy, String n)
	{
		super(n);
		setLocation(xx,yy);
	}
	
	public CarWithBoat(double xx, double yy, String n, Color c)
	{
		super(xx,yy,n,c);
	}
	public CarWithBoat(double xx, double yy, String n, Color c, double s)
	{
		super(xx,yy,n,c,s);
	}
	public void paint(Graphics g)
	{	
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.fill(latch);
		g2.fill(wheel);
		g2.setColor(new Color(0,0,200));
		g2.fill(base);
		g2.setColor(Color.WHITE);
		g2.fill(window);
	}
	
	public void drive()
	{
		super.drive();
		latch.setFrame(latch.getX()+getSpeed(),latch.getY(),120,5);
		wheel.setFrame(wheel.getX()+getSpeed(),wheel.getY(),120,5);
		base.translate((int)getSpeed(),0);
		window.translate((int)getSpeed(),0);
	}
	public void setLocation(double x, double y)
	{
		latch = new Rectangle2D.Double(x-80,y+7.5,80,5);
		super.setLocation(x,y);
		base = new Polygon(new int[]{(int)x-120,(int)x-100,(int)x-60,(int)x-40}, new int[]{(int)y,(int)y+20,(int)y+20,(int)y},4);
		window = new Polygon(new int[]{(int)x-100,(int)x-70,(int)x-60}, new int[]{(int)y,(int)y-20,(int)y}, 3);
		wheel = new Ellipse2D.Double(x-87.5,y+20,15,15);
	}
	public boolean contains(double x, double y)
	{
		return super.contains(x,y) || latch.contains(x,y) || base.contains(x,y)
			   || window.contains(x,y) || wheel.contains(x,y);
	}
	public double getWidth()
	{
		return 120+super.getWidth();
	}
	public String toString()
	{
		return "Car name: "+getName()+"\n"+stringColor()+"\n"+stringSpeed()+"\n"+"Has a trailer";
	}
}