package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test3 extends JFrame{
	int y =200;
	Test3(){
		setTitle("����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel3(), BorderLayout.CENTER);
		setSize(300,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test3();
	}

	class MyPanel3 extends JPanel implements ActionListener{
		MyPanel3(){
			setLayout(new BorderLayout());
			JPanel panel = new JPanel();
			JLabel label = new JLabel("��ư�� Click �غ��ƿ�");
			JButton button = new JButton("Click");
			button.addActionListener(this);
			panel.add(label);
			panel.add(button);
			add(panel, BorderLayout.NORTH);
		}
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(5));

			g.setColor(Color.red);
			g.drawLine(20,20,100,100);
			g.setColor(Color.blue);
			g.drawLine(100,100,200,100);
			g.drawLine(200,100,200,y);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			y+=10;
			repaint();
		}
	}
}
