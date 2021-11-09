package week10;

import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;

public class Timer1 extends JFrame {
	Container contentPane;
	DatePanel dPanel = new DatePanel();
	ChartPanel chartPanel = new ChartPanel();
	Timer1() {
		setTitle("Timer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		dPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
	//	contentPane.add(new InputPanel(), BorderLayout.NORTH);
		contentPane.add(chartPanel, BorderLayout.CENTER);
	//	contentPane.add(dPanel, BorderLayout.SOUTH);
		setSize(1500,500);
		setVisible(true);
	}

	class ChartPanel extends JPanel implements Runnable,ActionListener {
		Thread t1;
		Date today;
		String dateString1, dateString2;
	    String currentPattern;
	    SimpleDateFormat sdf1;
	    JComboBox patternList;
	    JLabel result = new JLabel();
	    
		ChartPanel() {		
	        String[] patternExamples = {
	        		 "yyyy년 MM월 dd일 (EEEEE)",
	                 "dd MMMMM yyyy",
	                 "dd.MM.yy",
	                 "MM/dd/yy",
	                 "EEE, MMM d, ''yy",
	                 "h:mm a",
	                 "H:mm:ss:SSS",
	                 "K:mm a,z",
	                 "EEE, MMM d, ''yy",
	                 "h:mm a",
	                 "hh 'o''clock' a, zzzz",
	                 "K:mm a, z",
	                 "yyMMddHHmmssZ",
	                 "YYYY-'W'ww-u"
	                 };	 
	        currentPattern = patternExamples[0];
	        patternList = new JComboBox(patternExamples);	       
	        patternList.addActionListener(this);	       
			add(patternList);			
		//	add(result);
			t1 = new Thread(this);
			t1.start();			
		}
	    public void actionPerformed(ActionEvent e) {
	        JComboBox cb = (JComboBox)e.getSource();
	        String newSelection = (String)cb.getSelectedItem();

	        currentPattern = newSelection;
			sdf1 =	new SimpleDateFormat(currentPattern);
			today = new Date();
			dateString1 = sdf1.format(today);
			result.setText(dateString1);
	    }
	    
		public void paintComponent(Graphics g) {
			super.paintComponent(g);			
			Font f = new Font("Ariel", Font.PLAIN, 70);
			Font f1 = new Font("Ariel", Font.BOLD, 100);
			g.setFont(f1);
			g.setColor(Color.RED);
			g.drawString(dateString1, 50, 200);	
			g.setFont(f);
			g.setColor(Color.BLUE);
			g.drawString(dateString2, 50, 350);
		}	
		
		public void run() {
			this.setBackground(Color.LIGHT_GRAY);			
			sdf1 = new SimpleDateFormat(currentPattern);	    
			SimpleDateFormat sdf2 =	new SimpleDateFormat("a h 시  mm 분   s 초 ");	
            
			while(true) {				
				today = new Date();      	     
	            dateString1 = sdf1.format(today);
	            dateString2 = sdf2.format(today);
	            repaint();
				try {
					Thread.sleep(1000); 
				}
				catch(InterruptedException e) {
					return; 
				}	        
			}
		}
	}
	
	class DatePanel extends JPanel implements Runnable {
		Thread t1 = null;
		JLabel result,r2;
		Date today;
		String dateString;
		
		DatePanel() {			
			t1 = new Thread(this);
			t1.start();			
		}
		
		public void run() {
			this.setBackground(Color.LIGHT_GRAY);			
			result = new JLabel(" ");
			SimpleDateFormat sdf1 =
					new SimpleDateFormat("yyyy 년 MM 월 dd 일  (E요일) , a h 시  mm 분   s 초 현재");	
            result.setForeground(Color.BLACK);
            add(result);                     
            
			while(true) {				
				today = new Date();      	     
	            dateString = sdf1.format(today);
	            result.setText(dateString);	

				try {
					Thread.sleep(1000); 
				}
				catch(InterruptedException e) {
					return; 
				}	        
			}
		}
		
	}
	

	
	public static void main(String [] args) {
		new Timer1();
	}
} 