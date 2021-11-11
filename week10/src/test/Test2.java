package test;

import javax.swing.*;
import java.awt.*;

public class Test2 extends JFrame{
	Test2(){
		setTitle("¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel2 panel = new MyPanel2();
		add(panel);
		setSize(400,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test2();
	}

}
class MyPanel2 extends JPanel {
	MyPanel2(){
		JLabel label = new JLabel("Welcome");
		JButton button = new JButton("Click");
		add(label);
		add(button);
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));

		g.setColor(Color.red);
		g.drawLine(20,20,100,100);
		g.setColor(Color.blue);
		g.drawLine(100,100,200,100);
		g.drawLine(200,100,200,200);
		

	}

}
