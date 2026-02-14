package com.project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;



public class home implements ActionListener

  {   
	JFrame frame;
    JButton bt1,bt2;
    JLabel l1;
	public home()
	{
		frame= new JFrame();
		frame.getContentPane().setBackground(new Color(200, 121, 181));
		
		
		l1= new JLabel("    Welcome To Chai Adda");
		l1.setFont(new Font("Tahoma", Font.BOLD, 18));
		l1.setForeground(new Color(255, 255, 255));
		l1.setBackground(new Color(128, 0, 255));
		l1.setBounds(320, 113, 242, 24);
		
		bt1= new JButton("User");
		bt1.setBackground(new Color(0, 0, 0));
		bt1.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt1.setForeground(new Color(255, 255, 255));
		bt1.setBounds(326, 208, 88, 22);
		
		
		bt2= new JButton("Admin");
		bt2.setBackground(new Color(0, 0, 0));
		bt2.setForeground(new Color(255, 255, 255));
		bt2.setBounds(478, 208, 98, 22);
		
		 bt1.addActionListener(this);
	     bt2.addActionListener(this);
		
		frame.getContentPane().add(l1);
		frame.getContentPane().add(bt1);
		frame.getContentPane().add(bt2);
		frame.setSize(918,525);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN AS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(419, 166, 88, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(home.class.getResource("/images/cafe (2).png")));
		lblNewLabel_1.setBounds(391, 25, 88, 77);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setVisible(true);	
 
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==bt2)
		{  
			frame.dispose();
			new LoginForm();
		}
		if(e.getSource()==bt1)
		{
			frame.dispose();
			new User();
			
		
		}
		
	}
	public static void main(String[] args) 
	{
		new home();
	}
}