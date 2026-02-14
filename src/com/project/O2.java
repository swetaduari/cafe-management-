package com.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

public class O2 extends JFrame {
	
    private JPanel contentPane;
    private JTable table;
    DefaultTableModel model;
    JLabel createImageLabel;
    

    public O2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(837, 456);
     //   setLocationRelativeTo(null); // optional (center screen)
        setVisible(true); 
      
        //setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(210, 79, 152, 152);
        panel_1.setOpaque(true);
        panel_1.setBackground(new Color(255, 182, 193));
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 27, 132, 80);
        panel_1.add(panel_2);
        
        JLabel lblNewLabel_1_1 = new JLabel("Pizza");
        lblNewLabel_1_1.setBounds(25, 11, 48, 14);
        panel_1.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_2_1 = new JLabel("200 Rs");
        lblNewLabel_2_1.setBounds(104, 11, 48, 14);
        panel_1.add(lblNewLabel_2_1);
        
        JButton btnNewButton_1 = new JButton("ADD");
        btnNewButton_1.setBounds(79, 119, 63, 22);
        panel_1.add(btnNewButton_1);
        
        panel_2.setLayout(new BorderLayout());
        panel_2.add(loadImage("/images/pizza.png", 130, 80), BorderLayout.CENTER);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setOpaque(true);
        panel_1_1.setBackground(new Color(255, 182, 193));
        panel_1_1.setBounds(29, 79, 152, 152);
        contentPane.add(panel_1_1);
        panel_1_1.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 24, 132, 84);
        panel_1_1.add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("Burger");
        lblNewLabel_1.setBounds(31, 11, 48, 14);
        panel_1_1.add(lblNewLabel_1);
        //image burger
        panel.setLayout(new BorderLayout());
        //panel.add(loadImage("/images/burger.png", 130, 80), BorderLayout.CENTER);

        
        JLabel lblNewLabel_2 = new JLabel("90 Rs");
        lblNewLabel_2.setBounds(94, 11, 48, 14);
        panel_1_1.add(lblNewLabel_2);
        
        JButton btnNewButton = new JButton("ADD");
        btnNewButton.setBounds(79, 119, 63, 22);
        panel_1_1.add(btnNewButton);
        
        //french fries
        JPanel panel_1_2 = new JPanel();
        panel_1_2.setOpaque(true);
        panel_1_2.setBackground(new Color(255, 182, 193));
        panel_1_2.setBounds(391, 79, 152, 152);
        contentPane.add(panel_1_2);
        panel_1_2.setLayout(null);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(10, 28, 132, 80);
        panel_1_2.add(panel_3);
        
        JLabel lblNewLabel_1_2 = new JLabel("french Fries");
        lblNewLabel_1_2.setBounds(27, 11, 66, 14);
        panel_1_2.add(lblNewLabel_1_2);
       // images
        panel_3.setLayout(new BorderLayout());
        panel_3.add(loadImage("/images/french-fries.png", 130, 80), BorderLayout.CENTER);

        
        JLabel lblNewLabel_2_1_1 = new JLabel("100 Rs");
        lblNewLabel_2_1_1.setBounds(94, 11, 48, 14);
        panel_1_2.add(lblNewLabel_2_1_1);
        
        JButton btnNewButton_1_1 = new JButton("ADD");
        btnNewButton_1_1.setBounds(79, 119, 63, 22);
        panel_1_2.add(btnNewButton_1_1);
        
        JPanel panel_1_3 = new JPanel();
        panel_1_3.setOpaque(true);
        panel_1_3.setBackground(new Color(255, 182, 193));
        panel_1_3.setBounds(29, 256, 152, 152);
        contentPane.add(panel_1_3);
        panel_1_3.setLayout(null);
        //latee
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(10, 28, 132, 84);
        panel_1_3.add(panel_4);
        
        JLabel lblNewLabel_1_3 = new JLabel("Latte");
        lblNewLabel_1_3.setBounds(24, 11, 48, 14);
        panel_1_3.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_2_2 = new JLabel("120 Rs");
        lblNewLabel_2_2.setBounds(94, 11, 48, 14);
        panel_1_3.add(lblNewLabel_2_2);
        
        JButton btnNewButton_1_2 = new JButton("ADD");
        btnNewButton_1_2.setBounds(79, 119, 63, 22);
        panel_1_3.add(btnNewButton_1_2);
        
        panel_4.setLayout(new BorderLayout());
        panel_4.add(loadImage("/images/latte.png", 130, 80), BorderLayout.CENTER);
        
        JPanel panel_1_4 = new JPanel();
        panel_1_4.setOpaque(true);
        panel_1_4.setBackground(new Color(255, 182, 193));
        panel_1_4.setBounds(210, 256, 152, 152);
        contentPane.add(panel_1_4);
        panel_1_4.setLayout(null);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBounds(10, 28, 132, 76);
        panel_1_4.add(panel_5);
        
        //cappucinoo
        panel_5.setLayout(new BorderLayout());
        panel_5.add(loadImage("/images/herbal-tea.png", 130, 80), BorderLayout.CENTER);

        
        JLabel lblNewLabel_1_3_1 = new JLabel("capuccinoo");
        lblNewLabel_1_3_1.setBounds(25, 11, 63, 14);
        panel_1_4.add(lblNewLabel_1_3_1);
        
        JLabel lblNewLabel_2_2_1 = new JLabel("100 Rs");
        lblNewLabel_2_2_1.setBounds(98, 11, 48, 14);
        panel_1_4.add(lblNewLabel_2_2_1);
        
        JButton btnNewButton_1_3 = new JButton("ADD");
        btnNewButton_1_3.setBounds(79, 119, 63, 22);
        panel_1_4.add(btnNewButton_1_3);
        
        JPanel panel_1_5 = new JPanel();
        panel_1_5.setOpaque(true);
        panel_1_5.setBackground(new Color(255, 182, 193));
        panel_1_5.setBounds(391, 256, 152, 152);
        contentPane.add(panel_1_5);
        panel_1_5.setLayout(null);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBounds(10, 29, 132, 76);
        panel_1_5.add(panel_6);
        panel_6.setLayout(new BorderLayout());
        panel_6.add(loadImage("/images/drink.png", 130, 80), BorderLayout.CENTER);
        
        
        JLabel lblNewLabel_1_3_1_1 = new JLabel("Taaza Chai");
        lblNewLabel_1_3_1_1.setBounds(24, 11, 79, 14);
        panel_1_5.add(lblNewLabel_1_3_1_1);
        
        JLabel lblNewLabel_2_2_1_1 = new JLabel("10 Rs");
        lblNewLabel_2_2_1_1.setBounds(94, 11, 48, 14);
        panel_1_5.add(lblNewLabel_2_2_1_1);
        
        JButton btnNewButton_1_4 = new JButton("ADD");
        btnNewButton_1_4.setBounds(79, 119, 63, 22);
        panel_1_5.add(btnNewButton_1_4);
        
        JLabel lblNewLabel = new JLabel("List of Frequently Ordered Items");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(186, 22, 383, 46);
        contentPane.add(lblNewLabel);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBounds(588, 22, 208, 386);
        contentPane.add(panel_7);
        panel_7.setLayout(null);
       
        
        String[] columns = {"Product", "Items", "Price"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 38, 188, 266);
        panel_7.add(scrollPane);

        
        JButton btnNewButton_2 = new JButton("pay");
        btnNewButton_2.setBounds(56, 315, 88, 22);
        panel_7.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Receipt");
        btnNewButton_3.setBounds(56, 348, 88, 22);
        panel_7.add(btnNewButton_3);
        
       
    }

    private JLabel loadImage(String path, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new JLabel(new ImageIcon(img));
    }

    
    
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(() -> {
        	User b = new User();
            b.setVisible(true);
        });
    }
}
