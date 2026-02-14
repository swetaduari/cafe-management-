package com.project;

import java.awt.EventQueue;



import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Font;



public class admin extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTable table;
	DefaultTableModel model;
	JScrollPane sp;
	DefaultTableModel orderModel;
	DefaultTableModel foodModel;
	JButton btn1,btn2,btn3,btn4,btn5,btnback2,btnback1,bg;
	
	private JTextField txtItem;
	private JTextField txtPrice;
	private JRadioButton rAvailable;
	private JRadioButton rNotAvailable;
	JButton btnAnnualIncome, btnTodayIncome, btnMonthlyIncome, btnDeleteItem;
	private JTextField textField;
	private JTextField textField_1;
	//private JTextField textField_2, txtFoodName, txtFoodPrice ;
	private JTextField textField_2, txtFoodName, txtFoodPrice, txtFoodType; // Added txtFoodType
	JButton btnSubmitItem;
	private JPanel rightContainer;
	private JPanel tablePanel;
	private JPanel addItemPanel;
	private JPanel addItemPanel_1;
   
	private JPanel deleteItemPanel;
	private JTextField txtDeleteName;
	private JButton btnDeleteSubmit;
	
	
	public admin()
	{     

		 setTitle("Cafe Shop Management System");
	        setSize(900, 500);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().setLayout(null);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(200, 121, 181));
	        panel.setBounds(0, 0, 205, 463);
	        getContentPane().add(panel);
	        panel.setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("WELCOME ADMIN");
	        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	 
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel.setForeground(new Color(255, 255, 255));
	        lblNewLabel.setBounds(0, 42, 197, 14);
	        panel.add(lblNewLabel);
	        
	        
	        //sidebar
	        
	        rightContainer = new JPanel();
	        rightContainer.setBounds(240, 120, 600, 300);
	        rightContainer.setLayout(null);
	        getContentPane().add(rightContainer);
	       
	        
	        //checkdata button
	        
	        JButton btn1 = new JButton("Check data");//button one
            btn1.addActionListener(new ActionListener()
    		
    	        	{
             	public void actionPerformed(ActionEvent e)
         	    {
    		      
             		
             		
             		check_data();
    		      
 
  	       
             }
    		});
	        btn1.setBounds(33, 100, 132, 22);
	        panel.add(btn1);
	        
	        //check customer Button
	        
	        JButton btn2 = new JButton("Check no cust");
	        btn2.setBounds(33, 133, 132, 22);
	        panel.add(btn2);
	        btn2.addActionListener(new ActionListener()
    		
    		{
             	public void actionPerformed(ActionEvent e)
         	{
    		      
             		
             		
             		check_customer();
    		      
 
  	       
             }
    		});
	       
	        
	        
	        //check income
	        JButton btn3 = new JButton("Check income");
	        btn3.setBounds(33, 166, 132, 22);
	        panel.add(btn3);
	        btn3.addActionListener(new ActionListener()
    		
    		{
             	public void actionPerformed(ActionEvent e)
         	{
    		      check_income();
    		       // switch table
 
  	       
             }
    		});
	  
	        
	        //Add items
	        JButton btn4= new JButton("Add items");
	        btn4.setBounds(33, 260, 132, 22);
	        panel.add(btn4);
	        
	        txtFoodType = new JTextField();
	        txtFoodType.setToolTipText("e.g., Beverage, Snack, Dessert");
	        txtFoodType.setBounds(150, 150, 200, 25);
	      
	        
	        btn4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                tablePanel.setVisible(false); // Hide the table
	                addItemPanel.setVisible(true); // Show the add item form
	            }
	        });
	        
	        addItemPanel = new JPanel();
	        addItemPanel.add(txtFoodType);
	        addItemPanel.setBounds(0, 0, 600, 300); // Same size as your rightContainer
	        addItemPanel.setBackground(new Color(240, 240, 240));
	        addItemPanel.setLayout(null);
	        addItemPanel.setVisible(false); // Hidden by default
	        rightContainer.add(addItemPanel);

	        JLabel lblName = new JLabel("Item Name:");
	        lblName.setBounds(50, 50, 100, 25);
	        addItemPanel.add(lblName);

	        txtFoodName = new JTextField();
	        txtFoodName.setBounds(150, 50, 200, 25);
	        addItemPanel.add(txtFoodName);

	        JLabel lblPrice = new JLabel("Price:");
	        lblPrice.setBounds(50, 100, 100, 25);
	        addItemPanel.add(lblPrice);

	        txtFoodPrice = new JTextField();
	        txtFoodPrice.setBounds(150, 100, 200, 25);
	        addItemPanel.add(txtFoodPrice);

	        btnSubmitItem = new JButton("OK");
	        btnSubmitItem.setBounds(150, 191, 80, 30);
	        addItemPanel.add(btnSubmitItem);
	        
	        JLabel lblNewLabel_2 = new JLabel("Type");
	        lblNewLabel_2.setBounds(50, 155, 48, 14);
	        addItemPanel.add(lblNewLabel_2);

	        // Action listener for the OK button
	        btnSubmitItem.addActionListener(e -> save_item_to_db());
	        
	      
	        //list of food
	        JButton btn5= new JButton("list of food");
	        btn5.setBounds(33, 199, 132, 22);
	        panel.add(btn5);
	        
	     // --- Inside public admin() constructor ---

	     // Change from: JButton btnAnnualIncome = new JButton("Annual income");
	     // To:
	     btnAnnualIncome = new JButton("Annual income");
	     btnAnnualIncome.setBounds(33, 351, 132, 22);
	     panel.add(btnAnnualIncome);

	     // Change from: JButton btnTodaysIncome = new JButton("today's income");
	     // To:
	     btnTodayIncome = new JButton("today's income");
	     btnTodayIncome.setBounds(33, 384, 132, 22);
	     panel.add(btnTodayIncome);

	     // Change from: JButton btnMonthlyIncome = new JButton("monthly income");
	     // To:
	     btnMonthlyIncome = new JButton("monthly income");
	     btnMonthlyIncome.setBounds(33, 417, 132, 22);
	     panel.add(btnMonthlyIncome);
	     
	  // --- Inside public admin() constructor, after button initialization ---

	  // Annual Income (no specific textfield update requested)
	  btnAnnualIncome.addActionListener(e -> showIncome("Annual", "YEAR(date) = YEAR(CURDATE())", null));

	  // Today's Income (no specific textfield update requested)
	  btnTodayIncome.addActionListener(e -> showIncome("Today's", "DATE(date) = CURDATE()", null));

	  // Monthly Income (Updates textField_2)
	  btnMonthlyIncome.addActionListener(e -> showIncome("Monthly", "MONTH(date) = MONTH(CURDATE()) AND YEAR(date) = YEAR(CURDATE())", textField_2));
	     
	     
	     
	        JLabel lblNewLabel_3 = new JLabel("CHECK INFO");
	        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
	        lblNewLabel_3.setBounds(33, 75, 118, 14);
	        panel.add(lblNewLabel_3);
	        
	        JLabel lblNewLabel_3_1 = new JLabel("CHANGE:");
	        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	        lblNewLabel_3_1.setBounds(33, 232, 118, 14);
	        panel.add(lblNewLabel_3_1);
	        
	        JLabel lblNewLabel_3_1_1 = new JLabel("CHECK INCOME");
	        lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	        lblNewLabel_3_1_1.setBounds(33, 326, 118, 14);
	        panel.add(lblNewLabel_3_1_1);
	        
	        JButton btnDeleteItem = new JButton("Delete item");
	        btnDeleteItem.setBounds(33, 293, 132, 22);
	        panel.add(btnDeleteItem);
	        
	        btnDeleteItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                tablePanel.setVisible(false);
	                addItemPanel.setVisible(false); // Hide other panels
	                deleteItemPanel.setVisible(true); // Show delete panel
	            }
	        });
	        
	        
	     // --- DELETE ITEM PANEL SETUP ---
	        deleteItemPanel = new JPanel();
	        deleteItemPanel.setBounds(0, 0, 600, 300); 
	        deleteItemPanel.setBackground(new Color(240, 240, 240));
	        deleteItemPanel.setLayout(null);
	        deleteItemPanel.setVisible(false); // Hidden initially
	        rightContainer.add(deleteItemPanel);

	        JLabel lblDelete = new JLabel("Enter Item Name to Delete:");
	        lblDelete.setBounds(50, 50, 200, 25);
	        deleteItemPanel.add(lblDelete);

	        txtDeleteName = new JTextField();
	        txtDeleteName.setBounds(250, 50, 200, 25);
	        deleteItemPanel.add(txtDeleteName);

	        btnDeleteSubmit = new JButton("OK");
	        btnDeleteSubmit.setBounds(250, 100, 80, 30);
	        deleteItemPanel.add(btnDeleteSubmit);

	        // Action Listener to execute deletion
	        btnDeleteSubmit.addActionListener(e -> delete_item_from_db());
	        
	        
	     // Assuming you have a JButton for 'Delete item'
	      
	        btn5.addActionListener(new ActionListener()
	        		
	        		{
	                 	public void actionPerformed(ActionEvent e)
	             	{
	        		      list_of_food();
	        		      table.setModel(foodModel);   // switch table
	     
	      	       
	                 }
	        		});
	      
	           
	      //table
	        tablePanel = new JPanel();
	        tablePanel.setBounds(0, 0, 600, 300);
	        tablePanel.setLayout(null);
	        rightContainer.add(tablePanel);

	     
	        // Orders table model
	        String[] orderCols = {"ID", "Gender", "Items", "Total Amount", "Date"};
	        orderModel = new DefaultTableModel(orderCols, 0);

	        // Food list table model
	        String[] foodCols = {"Food ID", "Name", "Price", "Type","access"};
		    foodModel = new DefaultTableModel(foodCols, 0);
	        table = new JTable(orderModel);

	        JScrollPane sp = new JScrollPane(table);
	        sp.setBounds(10, 11, 580, 252);
	        tablePanel.add(sp);

	        JButton btnRefresh = new JButton("Refresh Table");
	        btnRefresh.setBounds(210, 265, 180, 28);
	        tablePanel.add(btnRefresh);
	        tablePanel.setVisible(true);
	        
	      
       	 

	        
	      


            // refresh button
	        tablePanel.add(btnRefresh);

	        JScrollBar scrollBar = new JScrollBar();
	        sp.setRowHeaderView(scrollBar);
		   
		    
		    JPanel panel_1 = new JPanel();
		    panel_1.setBackground(new Color(184, 136, 185));
		    panel_1.setBounds(242, 11, 170, 89);
		    getContentPane().add(panel_1);
		    panel_1.setLayout(null);
		    
		    JLabel lblNewLabel_1 = new JLabel("Income");
		    lblNewLabel_1.setBounds(21, 64, 48, 14);
		    panel_1.add(lblNewLabel_1);
		    
		    textField = new JTextField();
		    textField.setBounds(64, 61, 96, 20);
		    panel_1.add(textField);
		    textField.setColumns(10);
		    
		    JPanel panel_1_1 = new JPanel();
		    panel_1_1.setBackground(new Color(184, 136, 185));
		    panel_1_1.setBounds(440, 11, 170, 89);
		    getContentPane().add(panel_1_1);
		    panel_1_1.setLayout(null);
		    
		    textField_1 = new JTextField();
		    textField_1.setColumns(10);
		    textField_1.setBounds(97, 58, 63, 20);
		    panel_1_1.add(textField_1);
		    
		    JLabel lblNewLabel_1_1 = new JLabel("Customers");
		    lblNewLabel_1_1.setBounds(10, 61, 77, 14);
		    panel_1_1.add(lblNewLabel_1_1);
		    
		    JPanel panel_1_1_1 = new JPanel();
		    panel_1_1_1.setBackground(new Color(184, 136, 185));
		    panel_1_1_1.setBounds(636, 11, 170, 89);
		    getContentPane().add(panel_1_1_1);
		    panel_1_1_1.setLayout(null);
		    
		    textField_2 = new JTextField();
		    textField_2.setColumns(10);
		    textField_2.setBounds(98, 58, 62, 20);
		    panel_1_1_1.add(textField_2);
		    //label montly income
		    
		   JLabel lblNewLabel_1_1_1 = new JLabel("Montly Income");
		   lblNewLabel_1_1_1.setBounds(10, 61, 77, 14);
		    panel_1_1_1.add(lblNewLabel_1_1_1);
		    
		    	       
		    	        // back button of food model
		    	        
		    	JButton btnback1 = new JButton("Back");
		     btnback1.setBounds(454, 424, 170, 28);
		     
		    	 getContentPane().add(btnback1);
		    	 btnback1.setVisible(true);
		    	
		    	 btnback1.addActionListener(e -> {
		    	        	
		    	        	//  orderModel.setVisible(true);
		    	        	// foodModel.setVisible(false);
		    	          table.setModel(orderModel);  // restore table
		    	            btnback1.setVisible(true);
		    	        });
	        
	       
			
			  
	        
	    
	}


	
	  
         //list_of_food
	    void list_of_food()
        {
	    	 foodModel.setRowCount(0);
	    	
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
        	        foodModel.addRow(new Object[]{
                            id, name, price, type, acess
                    });
        		}
        		 con.close();

        	        // Set model to table
        	        table.setModel(foodModel);
        		
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        	
        }

   void check_data()
   {
	   orderModel.setRowCount(0);
   	
   	String host="jdbc:mysql://localhost:3306/";
   	String db="cafe_management";
   	String url=host+db;
   	
   	try
   	{
   		Class.forName("com.mysql.jdbc.Driver");
   		Connection con=DriverManager.getConnection(url,"root","");
   		Statement stmt=con.createStatement();
   		String sql="select* from customer";
   		ResultSet met=stmt.executeQuery(sql);
   		 System.out.println("cust_id"+"\t"+"gender"+"\t"+"items"+"\t"+"total_amount"+"date");
   		while(met.next())
   		{
   		
   			int cust_id= met.getInt("cust_id");
   			String gender= met.getString("gender");
   			int items= met.getInt("items");
   	        int total_amount= met.getInt("total_amount");
   	        String date= met.getString("date");
   	  
	        System.out.println(cust_id+"\t"+gender+"\t"+items+"\t"+total_amount+"\t"+date);
	        orderModel.addRow(new Object[]{
	        		cust_id,gender,items,total_amount,date
            
         });  
   	      
   		}
   		 con.close();

   	        // Set model to table
   	        table.setModel(orderModel);
   		
   	}
   	catch(Exception e)
   	{
   		e.printStackTrace();
   	}
   	
  }
   
   void check_customer() {

	    String url = "jdbc:mysql://localhost:3306/cafe_management";

	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, "root", "");

	        String sql = "SELECT COUNT(*) FROM customer";
	        PreparedStatement pst = con.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt(1);
	            textField_1.setText(String.valueOf(count));
	        }

	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
   
   void check_income() {
	    // 1. Updated URL to include 'useSSL=false' for local dev compatibility
	    String url = "jdbc:mysql://localhost:3306/cafe_management?useSSL=false&allowPublicKeyRetrieval=true";

	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, "root", "");

	        // 2. We use CAST to ensure the database returns a DOUBLE/CHAR 
	        // if the driver is struggling with the DECIMAL type (246).
	        String sql = "SELECT CAST(IFNULL(SUM(total_amount), 0) AS DOUBLE) FROM customer";
	        
	        // 3. Using a regular Statement can sometimes bypass binary-encoding errors 
	        // found in older drivers using PreparedStatements.
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        if (rs.next()) {
	            // Using getDouble or getBigDecimal is safer for currency
	            double income = rs.getDouble(1);
	            // Format to 2 decimal places for a cleaner UI
	            textField.setText(String.format("%.2f", income));
	        }

	        rs.close();
	        stmt.close();
	        con.close();

	    } catch (Exception e) {
	        System.err.println("Error calculating income:");
	        e.printStackTrace();
	    }
	}
   void save_item_to_db() {
	    String name = txtFoodName.getText();
	    String price = txtFoodPrice.getText();
	    String type = txtFoodType.getText(); // Get text from the new field

	    if (name.isEmpty() || price.isEmpty() || type.isEmpty()) {
	        javax.swing.JOptionPane.showMessageDialog(this, "Please fill all fields");
	        return;
	    }

	    // Standardized URL to prevent driver errors
	    String url = "jdbc:mysql://localhost:3306/cafe_management?useSSL=false&allowPublicKeyRetrieval=true";
	    
	    try {
	        Class.forName("com.mysql.jdbc.Driver"); // Use modern driver class
	        Connection con = DriverManager.getConnection(url, "root", "");
	        
	        // Updated SQL to use the 'type' provided by the user
	        String sql = "INSERT INTO food (name, price, type, acess) VALUES (?, ?, ?, 'Available')";
	        PreparedStatement pst = con.prepareStatement(sql);
	        
	        pst.setString(1, name);
	        pst.setDouble(2, Double.parseDouble(price));
	        pst.setString(3, type); // Insert the type here

	        int rows = pst.executeUpdate();
	        if (rows > 0) {
	            javax.swing.JOptionPane.showMessageDialog(this, "Data added successfully!");
	            
	            // Reset fields
	            txtFoodName.setText("");
	            txtFoodPrice.setText("");
	            txtFoodType.setText("");
	            
	            // Switch back to table view
	            addItemPanel.setVisible(false);
	            tablePanel.setVisible(true);
	            list_of_food(); 
	        }
	        con.close();
	    } catch (NumberFormatException e) {
	        javax.swing.JOptionPane.showMessageDialog(this, "Price must be a valid number!");
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        javax.swing.JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
	    }
	}
   void delete_item_from_db() {
	    String itemName = txtDeleteName.getText().trim();

	    if (itemName.isEmpty()) {
	        javax.swing.JOptionPane.showMessageDialog(this, "Please enter an item name to delete.");
	        return;
	    }

	    // Confirm before deleting
	    int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
	        "Are you sure you want to delete '" + itemName + "'?", "Confirm Deletion", 
	        javax.swing.JOptionPane.YES_NO_OPTION);

	    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
	        String url = "jdbc:mysql://localhost:3306/cafe_management?useSSL=false&allowPublicKeyRetrieval=true";
	        
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url, "root", "");
	            
	            String sql = "DELETE FROM food WHERE name = ?";
	            PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, itemName);

	            int rows = pst.executeUpdate();
	            if (rows > 0) {
	                javax.swing.JOptionPane.showMessageDialog(this, "Item deleted successfully!");
	                txtDeleteName.setText(""); // Clear field
	                
	                // Return to table view and refresh
	                deleteItemPanel.setVisible(false);
	                tablePanel.setVisible(true);
	                list_of_food(); 
	            } else {
	                javax.swing.JOptionPane.showMessageDialog(this, "Item not found in database.");
	            }
	            con.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
	        }
	    }
	}
   
   void showIncome(String period, String condition, JTextField targetField) {
	    // Standardized URL to prevent "No suitable driver" errors
	    String url = "jdbc:mysql://localhost:3306/cafe_management?useSSL=false&allowPublicKeyRetrieval=true";
	    
	    try {
	        Class.forName("com.mysql.jdbc.Driver"); // Use modern driver class
	        Connection con = DriverManager.getConnection(url, "root", "");
	        
	        // CAST solves the "type 246" binary error
	        String sql = "SELECT CAST(IFNULL(SUM(total_amount), 0) AS DOUBLE) FROM customer WHERE " + condition;
	        
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        if (rs.next()) {
	            double amount = rs.getDouble(1);
	            String formattedAmount = String.format("%.2f", amount);
	            
	            // 1. Show the pop-up
	            javax.swing.JOptionPane.showMessageDialog(this, 
	                "Total " + period + " Income: Rs" + formattedAmount,
	                period + " Income Report",
	                javax.swing.JOptionPane.INFORMATION_MESSAGE);

	            // 2. Update the specific text field if one was provided
	            if (targetField != null) {
	                targetField.setText(formattedAmount);
	            }
	        }
	        con.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        javax.swing.JOptionPane.showMessageDialog(this, "Error fetching " + period + " income: " + ex.getMessage());
	    }
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		  public static void main(String[] args) {
		        EventQueue.invokeLater(() -> {
		            admin a = new admin();
		            a.setVisible(true);
		        });
		    }
}


