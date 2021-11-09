package week10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Neko0 extends JFrame {
	Container contentPane;  
	Neko0() {
		setTitle("Neko Image");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();

		MyPanel panel = new MyPanel();
		contentPane.add(panel);
		setSize(600, 300);		  
		setVisible(true);
	}

	class MyPanel extends JPanel {
		Image nekopics[] = new Image[9];
		String nekosrc[] = { "right1.gif", "right2.gif", "stop.gif",
				"yawn.gif", "scratch1.gif", "scratch2.gif",
				"sleep1.gif", "sleep2.gif", "awake.gif" };
		Image currentimg;
		int xpos = 500;
		int ypos = 100;
		@SuppressWarnings("rawtypes")
		MyPanel(){
			ImageIcon imageIcon = new  ImageIcon("images/"+ nekosrc[0]);
			currentimg = imageIcon.getImage();
			setBackground(Color.white);

			@SuppressWarnings("unchecked")
			JComboBox button = new JComboBox(nekosrc);
			button.addActionListener(new  ActionListener(){
				public void actionPerformed(ActionEvent e) {				
					JComboBox cb = (JComboBox)e.getSource();
					int index = cb.getSelectedIndex();
					ImageIcon imageIcon = new  ImageIcon("images/"+ nekosrc[index]);
					currentimg = imageIcon.getImage();
					repaint();
				}
			}
					);
			add(button);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(currentimg, xpos, ypos,this);
		}

	}

	public static void main(String [] args) {
		new Neko0();
	}
}
