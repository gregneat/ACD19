import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class starter extends JPanel
{
	static JFrame frame;
	
	public static void main(String[] args) {
		EasyReader r_in = new EasyReader();
		System.out.println("Please enter Window height (minimum: 50)");
		int height = r_in.readInt();
		System.out.println("Please enter Window width (minimum: 325)");
		int width = r_in.readInt();
		System.out.println("Please enter a Window title");
		String cheese = r_in.readLine();
		frame = new JFrame(cheese);
		frame.add(new starter());
		frame.setSize(width,height);
		frame.setVisible(true);
	}
	
	public starter()
	{
		Color a = new Color(0,255,0);
		setBackground(a);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	
}