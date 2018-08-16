import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class starter extends JPanel implements KeyListener
{
	static JFrame frame;
	
	Rectangle2D.Double rect;
	int xCoord=150, yCoord=200;
	String key;
	
	public static void main(String[] args) {
		frame = new JFrame("App");
		frame.add(new starter());
		frame.setSize(600,600);
		frame.setVisible(true);
	}
	
	public starter()
	{
		Color a = new Color(0,255,0);
		setBackground(a);
		
		rect = new Rectangle2D.Double(xCoord,yCoord,50,50);
		
		frame.addKeyListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLUE);
		g2.fill(rect);
		g.setColor(Color.BLACK);
		g.drawString("Use the D key to move the rectangle right",150,300);
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			xCoord = xCoord+10;
		}
		
		rect.setFrame(xCoord,yCoord,rect.getWidth(),rect.getHeight());
		repaint();
	}
	
	public void keyReleased(KeyEvent e){}  
	public void keyTyped(KeyEvent e){} 

}

