package test;
import javax.swing.*;
import java.awt.*;
public class Test5 extends JFrame {
	Container contentPane;
	Test5() {
		setTitle("drawString ���  ����");
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
			g.setFont(new Font("���ü",Font.BOLD,30));
			g.drawString("�ڹٴ� ��մ�.~~", 30,60);
			g.drawString("�󸶳�? �ϴø�ŭ ����ŭ !!!!", 60, 160);

		}
	}

	public static void main(String [] args) {
		new Test5();
	}
} 
