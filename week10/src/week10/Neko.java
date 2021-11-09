package week10;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Neko extends JFrame {
  Container contentPane;  
  int k;
  Neko() {
		setTitle("Neko1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();

		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(600, 200);		  
		k= this.getWidth();
		setVisible(true);
	}
  
class MyPanel extends JPanel implements Runnable {
	  Image nekopics[] = new Image[9];
	  String nekosrc[] = { "right1.gif", "right2.gif", "stop.gif",
	                       "yawn.gif", "scratch1.gif", "scratch2.gif",
	                       "sleep1.gif", "sleep2.gif", "awake.gif" };
	  Image currentimg;
	  Thread runner;
	  int xpos;
	  int ypos = 50;

	  MyPanel(){
		  runner = new Thread(this);
		  runner.start();
	  }

	  public void run() {

	    // initialize
	    for (int i=0; i < nekopics.length; i++) {
	    	ImageIcon imageIcon = new  ImageIcon("images/"+ nekosrc[i]);
	    	nekopics[i] = imageIcon.getImage();
	    }
	    setBackground(Color.white);
	    
	    // run from one side of the screen to the middle
	    nekorun(0,k/2-10);
	    
	    // stop and pause
	    currentimg = nekopics[2];
	    repaint();
	    pause(1000);

	    // yawn
	    currentimg = nekopics[3];
	    repaint();
	    pause(1000);

	    // scratch four times
	    nekoscratch(4);

	    // sleep for 5 seconds
	    nekosleep(5);

	    // wake up and run off
	    currentimg = nekopics[8];
	    repaint();
	    pause(500);
	    nekorun(xpos, k-10);
	  }

	  void nekorun(int start, int end) {
	    for (int i = start; i < end; i+=10) {
	      this.xpos = i;
	      // swap images
	      if (currentimg == nekopics[0])
		currentimg = nekopics[1];
	      else if (currentimg == nekopics[1])
		currentimg = nekopics[0];
	      else currentimg = nekopics[0];

	      repaint();
	      pause(150);
	    }
	  }

	  void nekoscratch(int numtimes) {
	    for (int i = numtimes; i > 0; i--) {
	      currentimg = nekopics[4];
	      repaint();
	      pause(150);
	      currentimg = nekopics[5];
	      repaint();
	      pause(150);
	    }
	  }

	  void nekosleep(int numtimes) {
	    for (int i = numtimes; i > 0; i--) {
	      currentimg = nekopics[6];
	      repaint();
	      pause(250);
	      currentimg = nekopics[7];
	      repaint();
	      pause(250);
	    }
	  }

	  void pause(int time) {
	    try { Thread.sleep(time); }
	    catch (InterruptedException e) { }
	  }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(currentimg, xpos, ypos,this);
		}

	}
  
	public static void main(String [] args) {
		new Neko();
	}
	}
