package week10;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Lamp2 extends JFrame {
	Container contentPane;
	Lamp2() {
		setTitle("Lamp ¸¸µé±â");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(300, 330);
		setVisible(true);
	}

	class MyPanel extends JPanel implements Runnable {
		Thread t1 = null;
		Color c1;
		public MyPanel() {
			setOpaque(true);
			t1 = new Thread(this);
			t1.start();
		}
		
		public void run() {
			int n=0;
			while(true) {

				Random r= new Random();
				int x = r.nextInt(256);
				int y = r.nextInt(256);
				int z = r.nextInt(256);
				
				c1 = new Color(x,y,z);
				
				try {
					Thread.sleep(500); 
				}
				catch(InterruptedException e) {
					return; 
				}
				repaint();
			}
		}
	
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
		new Lamp2();
	}
} 
