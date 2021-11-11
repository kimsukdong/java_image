package test;

import javax.swing.*;

import java.awt.*;

public class Test1_1 extends JFrame{
	Test1_1(){
		setTitle("¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel1_1 panel = new MyPanel1_1();
		add(panel);
		setSize(400,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test1_1();
	}

}
class MyPanel1_1 extends JPanel {
	MyPanel1_1(){
		MyLabel label = new MyLabel("Welcome");
		MyButton button = new MyButton("Button");
		add(label);
		add(button);
	}
}

class MyButton extends JButton {
	MyButton(String s){
		super(s);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g.setColor(Color.RED);
	//	g.drawOval(0,0,this.getWidth()-3, this.getHeight()-3);
		g.drawLine(10,0,this.getWidth()/2,this.getHeight()-10);
		g.drawLine(this.getWidth()/2,this.getHeight()-10,this.getWidth()-10,0);

	}
}
class MyLabel extends JLabel {
	MyLabel(String s){
		super(s);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g.setColor(Color.BLUE);
		g.drawLine(0,this.getHeight()/2,this.getWidth(),this.getHeight()/2);

	}
}

