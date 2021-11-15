package week10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Neko1 extends JFrame {
	Container contentPane;  
	int width;
	Neko1() {
		setTitle("Neko Run");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();

		MyPanel panel = new MyPanel();
		contentPane.add(panel);
		setSize(500, 200);		
		width= this.getWidth();
		setVisible(true);
	}

	class MyPanel extends JPanel implements Runnable {
		Image nekopics1, nekopics2;	
		String nekosrc[] = { "right1.gif", "right2.gif"};
		Image currentimg;
		Thread runner;
		int xpos = 0;
		int ypos = 100;

		MyPanel(){			
			setBackground(Color.white);

			runner = new Thread(this);
			runner.start();
		}
		public void run() {
			ImageIcon imageIcon1 = new  ImageIcon("images/"+ nekosrc[0]);
			ImageIcon imageIcon2 = new  ImageIcon("images/"+ nekosrc[1]);
			nekopics1 = imageIcon1.getImage();
			nekopics2 = imageIcon2.getImage();

			for (int i = 0; i < width; i+=10) {
				this.xpos = i;

				if (currentimg == nekopics1)
					currentimg = nekopics2;
				else if (currentimg == nekopics2)
					currentimg = nekopics1;
				else currentimg = nekopics1;

				repaint();
				
				try {
					Thread.sleep(150);
					}
				catch (InterruptedException e) { }

			}
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(currentimg, xpos, ypos,this);
		}

	}

	public static void main(String [] args) {
		new Neko1();
	}
}
