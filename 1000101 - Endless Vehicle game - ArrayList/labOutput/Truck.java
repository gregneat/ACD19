//HIDE
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Truck implements Vehicle
{
	public static int TRUCKHEIGHT = 120;
	public static int TRUCKWIDTH = 255;
	private double sp;
    private double xCoord, yCoord, width, height;
	private Rectangle2D.Double body, cab;
	private Ellipse2D.Double wh1, wh2, wh3, wh4;
	private String label, locLabel;
	private Color bodyColor;

	int xx = 0;
	int yy = 100;
    public Truck()
    {
		body = new Rectangle2D.Double(xx,yy, 200,90);
		cab = new Rectangle2D.Double(xx-55,yy+40,50,50);
		wh1 = new Ellipse2D.Double(xx-15,yy+40+50-10,30,30);
		wh2 = new Ellipse2D.Double(xx+20,yy+40+50-10,30,30);
		wh3 = new Ellipse2D.Double(xx+125,yy+40+50-10,30,30);
		wh4 = new Ellipse2D.Double(xx+160,yy+40+50-10,30,30);
        xCoord = xx;
        yCoord = yy;
		bodyColor = Color.RED;
		locLabel = getX()+", "+getY();
		label= "";
		sp = 5;
    }
	
	public Truck(String n)
	{
		this();
		label = n;
	}
	
	public Truck(double x, double y, String n)
    {
		this(n);
		setLocation(x,y);
    }
	public Truck(double x, double y, String n, Color c)
    {
		this(x,y,n);
		bodyColor = c;
    }
	public Truck(double x, double y, String n, Color c, double s)
    {
		this(x,y,n,c);
		sp = s;
    }
	
	public void drive()
	{
		body.setFrame(body.getX()+getSpeed(),body.getY(),body.getWidth(),body.getHeight());
		cab.setFrame(cab.getX()+getSpeed(),cab.getY(),cab.getWidth(),cab.getHeight());
		wh1.setFrame(wh1.getX()+getSpeed(),wh1.getY(),wh1.getWidth(),wh1.getHeight());
		wh2.setFrame(wh2.getX()+getSpeed(),wh2.getY(),wh2.getWidth(),wh2.getHeight());
		wh3.setFrame(wh3.getX()+getSpeed(),wh3.getY(),wh3.getWidth(),wh3.getHeight());
		wh4.setFrame(wh4.getX()+getSpeed(),wh4.getY(),wh4.getWidth(),wh4.getHeight());
		locLabel = getX()+getSpeed()+", "+getY();
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(bodyColor);
		g2.fill(body);g2.fill(cab);
		g2.setColor(Color.BLACK);
		g2.fill(wh1);g2.fill(wh2);
		g2.fill(wh3);g2.fill(wh4);
		g.setColor(Color.WHITE);
		g.drawString(locLabel,(int)getX()+35,(int)getY()+45);
		g.drawString(label,(int)getX()+35,(int)getY()+25);
	}
	
	public void setLocation(double xx, double yy)
	{
		body.setFrame(xx,yy,200,90);
		cab.setFrame(xx-55,yy+40,50,50);
		wh1.setFrame(xx-55+10,yy+40+50-10,30,30);
		wh2.setFrame(xx+20,yy+40+50-10,30,30);
		wh3.setFrame(xx+125,yy+40+50-10,30,30);
		wh4.setFrame(xx+160,yy+40+50-10,30,30);
		locLabel = xx+", "+yy;
	}
	
	public double getX()
	{
		return body.getX();
	}
	
	public double getY()
	{
		return body.getY();
	}
	
	public double getSpeed()
	{
		return sp;
	}
	public double getHeight()
    {
        return TRUCKHEIGHT;
    }
	public double getWidth()
    {
        return TRUCKWIDTH;
    }

	public String getName()
	{
		return label;
	}
	// should improve this to include wheels or bounding box
	
	public boolean contains(double x, double y)
	{
		return body.contains(x,y)||cab.contains(x,y)||wh1.contains(x,y)||
		wh2.contains(x,y)||wh3.contains(x,y)||wh4.contains(x,y);
	}
	
	public void changeSpeed(double ns)
	{
		sp=ns;
	}
	
	public Rectangle2D.Double[] getBounds()
	{
		Rectangle2D.Double[] r = new Rectangle2D.Double[2];
	
		r[0] = new Rectangle2D.Double(body.getX(),body.getY(),body.getWidth(),
		body.getHeight()+wh1.getHeight());
		
		r[1] = new Rectangle2D.Double(cab.getX(),cab.getY(),cab.getWidth(),
		cab.getHeight()+wh1.getHeight());
		
		return r;
	}
}
