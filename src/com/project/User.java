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
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class User extends JFrame {

    private JPanel contentPane;
    private JTable table,table2;
    DefaultTableModel model,model1;
    JLabel createImageLabel;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    

    public User() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(840, 510);
     //   setLocationRelativeTo(null); // optional (center screen)
        setVisible(true); 
      
        //setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("List of Frequently Ordered Items");
        lblNewLabel.setBounds(124, 0, 383, 46);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblNewLabel);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(128, 255, 255));
        panel_7.setBounds(585, 49, 212, 424);
        contentPane.add(panel_7);
        panel_7.setLayout(null);
       
        
        String[] columns = {"Product", "Items", "Price"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 31, 188, 265);
        panel_7.add(scrollPane);

        
        JButton btnNewButton_2 = new JButton("pay");
        btnNewButton_2.setBounds(56, 347, 88, 22);
        panel_7.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              pay();
            }
        });


            

        
        JButton btnNewButton_3 = new JButton("Receipt");
        btnNewButton_3.setBounds(56, 380, 88, 22);
        panel_7.add(btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReceipt();
            }
        });
        
        textField = new JTextField();
        textField.setBounds(111, 305, 62, 20);
        panel_7.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton_4 = new JButton("Total");
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_4.setBounds(20, 304, 88, 22);
        panel_7.add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int total = 0;

                for (int i = 0; i < model.getRowCount(); i++) {
                    int price = Integer.parseInt(model.getValueAt(i, 2).toString());
                    total += price;
                }

                textField.setText(String.valueOf(total));
            }
        });

        
       
        
     // Columns for table2
        String[] columns2 = {"ID", "Name", "Price","Type","Acess"};
        model1 = new DefaultTableModel(columns2, 0);

        // Create table2
        table2 = new JTable(model1);

        // Add table2 inside scroll pane
        JScrollPane sp1 = new JScrollPane(table2);
        sp1.setBounds(39, 81, 486, 260);
        contentPane.add(sp1);
        
        JLabel lblNewLabel_2 = new JLabel("Food_id");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(63, 392, 58, 14);
        contentPane.add(lblNewLabel_2);
        
        textField_1 = new JTextField();
        textField_1.setBounds(131, 391, 96, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Quantity");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(63, 430, 69, 14);
        contentPane.add(lblNewLabel_3);
        
        textField_2 = new JTextField();
        textField_2.setBounds(131, 429, 96, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JButton btnNewButton = new JButton("ADD");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBackground(new Color(128, 255, 128));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		addToCart();
        	}
        });
        btnNewButton.setBounds(299, 402, 88, 37);
        contentPane.add(btnNewButton);
        // show food items
        JButton btnNewButton_1 = new JButton("show food items");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_1.setBounds(206, 352, 151, 22);
        contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel_1 = new JLabel("Search Item");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setBounds(39, 56, 82, 14);
        contentPane.add(lblNewLabel_1);
        
        
     // Locate your search button in the UI setup
       
        
        textField_3 = new JTextField();
        textField_3.setBounds(119, 53, 96, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        
        JButton btnNewButton_5 = new JButton("Search");
        btnNewButton_5.setBounds(228, 49, 88, 22);
        contentPane.add(btnNewButton_5);
        
        
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                search_food_item();
            }
        });
        
        btnNewButton_1.addActionListener(new ActionListener()
		
		{
         	public void actionPerformed(ActionEvent e)
     	{
		      list_of_food1();
		        

	       
         }
		});

      //  setVisible(true);
       
    }

  void list_of_food1()
  {

 	 model1.setRowCount(0);
 	
 	String host="jdbc:mysql://localhost:3306/";
 	String db="cafe_management";
 	String url=host+db;
 	
 	try
 	{
 		Class.forName("com.mysql.jdbc.Driver");
 		Connection con=DriverManager.getConnection(url,"root","");
 		Statement stmt=con.createStatement();
 		String sql="select* from food";
 		ResultSet set=stmt.executeQuery(sql);
 		 System.out.println("id"+"\t"+"name"+"\t"+"price"+"\t"+"type"+"\t"+"acess");
 		while(set.next())
 		{
 			int id =set.getInt("food_id");
 			String name= set.getString("name");
 			int price= set.getInt("price");
 			String type= set.getString("type");
 	        String acess= set.getString("acess");
 	        
 	        System.out.println(id+"\t"+name+"\t"+price+"\t"+type+"\t"+acess);
 	        model1.addRow(new Object[]{
 	        		 id, name, price, type, acess
             });
 		}
 		 con.close();

 	        // Set model to table
 	        table2.setModel(model1);
 		
 	}
 	catch(Exception e)
 	{
 		e.printStackTrace();
 	}
 	
 
  }
  private void addToCart() {
	  if (textField_1.getText().isEmpty() || textField_2.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(this,
	                "Please enter Food ID and Quantity",
	                "Input Error",
	                JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    try {
	        int foodId = Integer.parseInt(textField_1.getText());
	        int quantity = Integer.parseInt(textField_2.getText());
	        boolean found = false;
	        // Get data from left table (table2)
	        for (int i = 0; i < table2.getRowCount(); i++) {

	            int id = Integer.parseInt(table2.getValueAt(i, 0).toString());

	            if (id == foodId)
	            {

	                String name = table2.getValueAt(i, 1).toString();
	                int price = Integer.parseInt(table2.getValueAt(i, 2).toString());

	                int totalPrice = price * quantity;

	                // Add to right table
	                model.addRow(new Object[]{
	                        name,
	                        quantity,
	                        totalPrice
	                });
	                found = true;
	                break;
	            }
	            
	            

	        }
	        if (!found) {
                JOptionPane.showMessageDialog(this,
                        "Food ID not found!",
                        "Invalid ID",
                        JOptionPane.ERROR_MESSAGE);
            }

	        // Clear fields after adding
	        textField_1.setText("");
	        textField_2.setText("");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
  void pay() {
	    if (model.getRowCount() == 0) {
	        JOptionPane.showMessageDialog(this, "Cart is empty!", "Payment Error", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    try {
	        // 1. Calculate totals
	        int totalQuantity = 0;
	        int totalAmount = 0;

	        for (int i = 0; i < model.getRowCount(); i++) {
	            totalQuantity += Integer.parseInt(model.getValueAt(i, 1).toString());
	            totalAmount += Integer.parseInt(model.getValueAt(i, 2).toString());
	        }

	        // 2. Update UI: Set the total field
	        textField.setText(String.valueOf(totalAmount));

	        // 3. DB connection with driver fix
	        String url = "jdbc:mysql://localhost:3306/cafe_management?useSSL=false";
	        Connection con = DriverManager.getConnection(url, "root", "");

	        String sql = "INSERT INTO customer (items, total_amount, date) VALUES (?, ?, ?)";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setInt(1, totalQuantity);
	        pst.setInt(2, totalAmount);
	        pst.setDate(3, new java.sql.Date(System.currentTimeMillis()));

	        pst.executeUpdate();
	        con.close();

	        JOptionPane.showMessageDialog(this, "Successfully done payment", "Payment", JOptionPane.INFORMATION_MESSAGE);

	        // IMPORTANT: We do NOT clear the cart or textField here so the Receipt can read the data.
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Payment failed!", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
  void search_food_item() {
	    String searchName = textField_3.getText().trim(); // Use the search text field

	    if (searchName.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Please enter an item name to search.");
	        return;
	    }

	    model1.setRowCount(0); // Clear the current table view

	    String url = "jdbc:mysql://localhost:3306/cafe_management?useSSL=false&allowPublicKeyRetrieval=true";
	    
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, "root", "");
	        
	        // Search query for food name
	        String sql = "SELECT * FROM food WHERE name LIKE ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, "%" + searchName + "%");

	        ResultSet rs = pst.executeQuery();

	        boolean found = false;
	        while (rs.next()) {
	            found = true;
	            int id = rs.getInt("food_id");
	            String name = rs.getString("name");
	            int price = rs.getInt("price");
	            String type = rs.getString("type");
	            String access = rs.getString("acess");

	            model1.addRow(new Object[]{id, name, price, type, access});
	        }

	        if (!found) {
	            JOptionPane.showMessageDialog(this, "Sorry, item not available");
	        }

	        con.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
	    }
	}
  
 
  private void generateReceipt() {
	    // 1. Check if pay was clicked (textField will have a value if pay() was successful)
	    if (textField.getText().isEmpty() || textField.getText().equals("0")) {
	        JOptionPane.showMessageDialog(this, "First pay the bill", "Message", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    String totalAmount = textField.getText();
	    String filePath = "D:\\bill.txt"; 

	    try {
	        // 2. Fetch last Customer ID from DB
	        String url = "jdbc:mysql://localhost:3306/cafe_management?useSSL=false";
	        Connection con = DriverManager.getConnection(url, "root", "");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT MAX(cust_id) FROM customer");
	        
	        String custId = "Unknown";
	        if (rs.next()) {
	            custId = String.valueOf(rs.getInt(1));
	        }
	        con.close();

	        // 3. Format Items
	        StringBuilder itemsList = new StringBuilder();
	        for (int i = 0; i < model.getRowCount(); i++) {
	            itemsList.append(model.getValueAt(i, 0)).append(" (x").append(model.getValueAt(i, 1)).append("), ");
	        }
	        
	        String currentDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());

	        // 4. Generate the text file
	        java.io.PrintWriter writer = new java.io.PrintWriter(filePath);
	        writer.println("======= CAFE SHOP RECEIPT =======");
	        writer.println("Thank you for visiting us!");
	        writer.println("Customer ID: " + custId);
	        writer.println("Date: " + currentDate);
	        writer.println("Items: " + itemsList.toString());
	        writer.println("Total Amount: $" + totalAmount);
	        writer.println("=================================");
	        writer.close();

	        JOptionPane.showMessageDialog(this, "Receipt generated successfully at " + filePath);
	        
	        // 5. Clear fields for the next customer
	        model.setRowCount(0);
	        textField.setText("");

	    } catch (java.io.FileNotFoundException fe) {
	        JOptionPane.showMessageDialog(this, "Error: Cannot write to C: drive. Please check permissions.", "File Error", JOptionPane.ERROR_MESSAGE);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error generating receipt: " + ex.getMessage());
	    }
	}


	

    
    
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(() -> {
        	User b = new User();
            b.setVisible(true);
        });
    }
}
