package week10;

import javax.swing.*;
import java.awt.*;

public class Lamp2 extends JFrame {
	Container contentPane;
	Lamp2() {
		setTitle("Lamp 만들기");
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
			while(true) { // 무한 루프
				if(n == 0)
					c1 = Color.PINK;
				else if(n == 1)
					c1 = Color.MAGENTA;
				else if(n == 2)
					c1 = Color.YELLOW;

				// n을 0과 1로 번갈아 변경
				if(n == 0) n = 1;
				else if(n == 1) n=2;
				else n = 0;
				
				try {
					Thread.sleep(200); // 0.5초동안 잠을 잔다.
				}
				catch(InterruptedException e) {
					return; // 예외가 발생하면 스레드 종료
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
