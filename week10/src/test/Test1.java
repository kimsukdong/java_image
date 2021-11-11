package test;

import javax.swing.*;
import javax.swing.JPanel;

import java.awt.*;

public class Test1 extends JFrame{
	Test1(){
		setTitle("¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel1 panel = new MyPanel1();
		add(panel);
		setSize(400,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test1();
	}

}
class MyPanel1 extends JPanel {
	MyPanel1(){
		JLabel label = new JLabel("Welcome");
		JButton button = new JButton("Click");
		add(label);
		add(button);
	}


}
