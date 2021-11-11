package test;
import javax.swing.*;
import java.awt.*;
public class Test5 extends JFrame {
	Container contentPane;
	Test5() {
		setTitle("drawString 사용  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel , BorderLayout.CENTER);
		setSize(600,400);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
	//		g.setColor(new Color(255,0,0));
			g.setColor(new Color(0x771fbf));
			g.setFont(new Font("고딕체",Font.BOLD,30));
			g.drawString("자바는 재밌다.~~", 30,60);
			g.drawString("얼마나? 하늘만큼 땅만큼 !!!!", 60, 160);

		}
	}

	public static void main(String [] args) {
		new Test5();
	}
} 
