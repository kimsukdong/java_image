package week10;

import javax.swing.*;
import java.awt.*;

public class Lamp extends JFrame {
	Container contentPane;
	Lamp() {
		setTitle("Lamp ¸¸µé±â");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(300, 330);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		Color c1;
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
		    // the platform        
			g.setColor(Color.BLUE  );
		    g.fillRect(0,250,300,50);                 
		                                               
		    // the base of the lamp      
		    g.setColor(Color.GRAY );
		    g.drawLine(125,250,125,160);               
		    g.drawLine(175,250,175,160);               
		                                               
		    // the lamp shade; two arcs         
		    g.setColor(new Color(200,100,100));
		    g.drawArc(85,157,130,50,-67,312);          
		    g.drawArc(85,87,130,50,62,58);             
		                                               
		    g.drawLine(85,177,119,89);                 
		    g.drawLine(215,177,181,89);                
		                                               
		    // pattern on the shade           
		    g.setColor(c1);
		    g.fillArc(78,120,40,40,63,-174);           
		    g.fillOval(120,96,40,40);                  
		    g.fillArc(173,100,40,40,110,180);  
		}
	}

	public static void main(String [] args) {
		new Lamp();
	}
} 
