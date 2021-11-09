package week10;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Neko3 extends JFrame {
  Container contentPane;  
  Neko3() {
		setTitle("고양이 달리기2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(450, 470);		  
		setVisible(true);
	}
  
  class MyPanel extends JPanel implements Runnable {
	  String nekosrc[] = { "right1.gif", "right2.gif", "stop.gif",
              "yawn.gif", "scratch1.gif", "scratch2.gif",
              "sleep1.gif", "sleep2.gif", "awake.gif" };
	  BufferedImage nekopics[] = new BufferedImage[nekosrc.length];
	  BufferedImage neko_90[] = new BufferedImage[nekosrc.length];
	  BufferedImage neko_180[] = new BufferedImage[nekosrc.length];
	  BufferedImage neko_270[] = new BufferedImage[nekosrc.length];
	  BufferedImage neko_45[] = new BufferedImage[nekosrc.length];

	  BufferedImage currentimg;
	  BufferedImage img = null;
	  Thread runner;
	  int xpos=12;
	  int ypos=12;
	  
	  
	  MyPanel(){		
		    for (int i=0; i < nekosrc.length; i++) {
				  try {
					  currentimg = ImageIO.read(new File("images/"+ nekosrc[i]));
				  } catch (IOException e) { }
				  nekopics[i] =rotate(currentimg,0);
				  neko_90[i] =rotate(currentimg,90);
				  neko_180[i] =rotate(currentimg,180);
				  neko_270[i] =rotate(currentimg,270);
				  neko_45[i] =rotate(currentimg,45);
		    }		   
		    setBackground(Color.white);
		    runner = new Thread(this);
		    runner.start();
	  }
	  
	  public BufferedImage rotate(BufferedImage img,int rotation) {  
	      int w = img.getWidth();  
	      int h = img.getHeight();  
	      BufferedImage newImage = new BufferedImage(w, h, img.getType());
	      Graphics2D g2 = newImage.createGraphics();
	      g2.rotate(Math.toRadians(rotation), w/2, h/2);  
	      g2.drawImage(img,null,0,0);
	      return newImage;  
	  }

	  public void run() {
		  while(true) {

	    // y  down
	    nekorun1(0, 380);
	    
	    // x forward
	    nekorun2(0, 380);
	    
	    // y up
	    nekorun3(380, 0);
	    
	    // x backward	    
	    nekorun4(380, 0);
	    // diagonal  down
	         
	    //  nekorun5(0, 380);
	  	}
	  }
	  
	  void nekorun1(int start, int end) {
	    for (int i = start; i < end; i+=10) {
	    	this.ypos = i;
	    	this.xpos = 10;
//	    	this.xpos = 50;

	      // swap images
	    	if (currentimg == neko_90[0])
	    		currentimg = neko_90[1];
	    	else if (currentimg == neko_90[1])
	    		currentimg = neko_90[0];
	    	else currentimg = neko_90[0];

	    	repaint();
	    	pause(150);
	    	
	    	
	    }
	  }
	  
	  void nekorun2(int start, int end) {
		  
		    currentimg = nekopics[2];
		    repaint();
		    pause(1000);
		    
		    for (int i = 3; i > 0; i--) {
			      currentimg = nekopics[6];
			      repaint();
			      pause(250);
			      currentimg = nekopics[7];
			      repaint();
			      pause(250);
			    }
		    
		    currentimg = nekopics[8];
		    repaint();
		    pause(500);
		    		    
		    for (int i = start; i < end; i+=10) {
		      this.xpos = i;
		      this.ypos = 375;
		  //    this.ypos = 125;
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
	 
	  void nekorun3(int start, int end) {
		  
		    currentimg = neko_270[2];
		    repaint();
		    pause(1000);
		    
		    for (int i = 3; i > 0; i--) {
			      currentimg = neko_270[6];
			      repaint();
			      pause(250);
			      currentimg = neko_270[7];
			      repaint();
			      pause(250);
			    }
		    
		    currentimg = neko_270[8];
		    repaint();
		    pause(500);
		    
		    for (int i = start; i > end; i-=10) {
		      this.ypos = i;
		      this.xpos = 375;
		      // swap images
		      if (currentimg == neko_270[0])
			currentimg = neko_270[1];
		      else if (currentimg == neko_270[1])
			currentimg = neko_270[0];
		      else currentimg = neko_270[0];

		      repaint();
		      pause(150);
		    }		    		
		    
		  }
		  
		void nekorun4(int start, int end) {
		    currentimg = neko_180[2];
		    repaint();
		    pause(1000);
		    
		    for (int i = 3; i > 0; i--) {
			      currentimg = neko_180[6];
			      repaint();
			      pause(250);
			      currentimg = neko_180[7];
			      repaint();
			      pause(250);
			    }
		    
		    currentimg = neko_180[8];
		    repaint();
		    pause(500);
		    
			    for (int i = start; i > end; i-=10) {
			      this.xpos = i;
			      this.ypos = 10;
			      // swap images
			      if (currentimg == neko_180[0])
				currentimg = neko_180[1];
			      else if (currentimg == nekopics[1])
				currentimg = neko_180[0];
			      else currentimg = neko_180[0];

			      repaint();
			      pause(150);
			    }
			    
			    currentimg = neko_90[2];
			    repaint();
			    pause(1000);
			    
			    for (int i = 3; i > 0; i--) {
				      currentimg = neko_90[6];
				      repaint();
				      pause(250);
				      currentimg = neko_90[7];
				      repaint();
				      pause(250);
				    }
			    
			    currentimg = neko_90[8];
			    repaint();
			    pause(500);
			  }
		
		void nekorun5(int start, int end) {
		    for (int i = start; i < end; i+=10) {
		      this.xpos = i;
		      this.ypos = i;
		      // swap images
		      if (currentimg == neko_45[0])
			currentimg = neko_45[1];
		      else if (currentimg == neko_45[1])
			currentimg = neko_45[0];
		      else currentimg = neko_45[0];

		      repaint();
		      pause(150);
		    }
		  }
		

	  void pause(int time) {
		    try { Thread.sleep(time); }
		    catch (InterruptedException e) { }
		  }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillRect(10, 10, 400, 400);
		g.setColor(Color.BLACK);
		g.drawRect(9, 9, 400, 400);
		/*
		g.drawRect(45, 45, 125, 125);
		g.drawRect(85, 85, 50, 50);
		*/
		g.drawImage(currentimg, xpos, ypos,this);
		}
	}
  
	public static void main(String [] args) {
		new Neko3();
	}
	}
