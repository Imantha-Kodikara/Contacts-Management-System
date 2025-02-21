import java.util.*;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.io.*;

public class SearchContact extends JFrame{
	private JPanel northPanel;
	private JPanel searchPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	
	private JButton btnSearch;
	private JButton btnBackToHomePage;
	
	private JTextField txtSearch;
	private JTextField txtContactId;
	private JTextField txtName;
	private JTextField txtContactNumber;
	private JTextField txtSalary;
	private JTextField txtCompany;
	private JTextField txtBirthDay;
	
	private JLabel lblHeader;
	private JLabel lblContactId;
	private JLabel lblName;
	private JLabel lblContactNumber;
	private JLabel lblCompany;
	private JLabel lblSalary;
	private JLabel lblBirthDay;
	
	SearchContact(){
		setSize(700, 500);
		setTitle("Search Contact");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
		
		northPanel = new JPanel(new BorderLayout(10,10));//Creating a JPanel to add header label and contct Id
		
		lblHeader = new JLabel("SEARCH CONTACT", JLabel.CENTER);
		lblHeader.setFont(new Font("", 1, 24));
		lblHeader.setOpaque(true);
		lblHeader.setBackground(new Color(173, 216, 230));
		
		northPanel.add("North", lblHeader); //lblHeader adding to the North of North Panel	
		
		searchPanel = new JPanel(new FlowLayout());
		
		txtSearch = new JTextField(15);
		txtSearch.setFont(new Font("", 1, 18));
		searchPanel.add(txtSearch);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("", 1, 18));
		searchPanel.add(btnSearch);
		
		northPanel.add("South", searchPanel);
		add("North", northPanel);
		
		centerPanel = new JPanel(new GridLayout(6, 2, 10, 10));
		
		lblContactId = new JLabel("Contact ID");
		lblContactId.setFont(new Font("", 1, 18));
		
		centerPanel.add(lblContactId);
		
		txtContactId = new JTextField();
		txtContactId.setFont(new Font("", 1, 18));
		txtContactId.setEditable(false);
		centerPanel.add(txtContactId);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("", 1, 18));
		centerPanel.add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("", 1, 18));
		txtName.setEditable(false);
		centerPanel.add(txtName);
		
		lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("", 1, 18));
		centerPanel.add(lblContactNumber);
		
		txtContactNumber = new JTextField();
		txtContactNumber.setFont(new Font("", 1, 18));
		txtContactNumber.setEditable(false);
		centerPanel.add(txtContactNumber);
		
		lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("", 1, 18));
		centerPanel.add(lblCompany);
		
		txtCompany = new JTextField();
		txtCompany.setFont(new Font("", 1, 18));
		txtCompany.setEditable(false);
		centerPanel.add(txtCompany);
		
		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("", 1, 18));
		centerPanel.add(lblSalary);
		
		txtSalary = new JTextField();
		txtSalary.setFont(new Font("", 1, 18));
		txtSalary.setEditable(false);
		centerPanel.add(txtSalary);
		
		lblBirthDay = new JLabel("BirthDay");
		lblBirthDay.setFont(new Font("", 1, 18));
		centerPanel.add(lblBirthDay);
		
		txtBirthDay = new JTextField();
		txtBirthDay.setFont(new Font("", 1, 18));
		txtBirthDay.setEditable(false);
		centerPanel.add(txtBirthDay);
		
		add("Center", centerPanel);
		
		southPanel = new JPanel(new FlowLayout());
		
		btnBackToHomePage = new JButton("Back To Home Page");
		btnBackToHomePage.setFont(new Font("", 1, 18));
		southPanel.add(btnBackToHomePage);
		
		add("South", southPanel);
		
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String nameOrContactNumber = txtSearch.getText();
				try{
					Contact contact = ContactsController.searchContact(nameOrContactNumber);
				
					if(contact == null){
						JOptionPane.showMessageDialog(null,nameOrContactNumber+" is not exists...");
						txtContactId.setText(""); 
						txtSearch.setText("");
						txtName.setText("");//Setting txtName text field empty
						txtContactNumber.setText("");//Setting txtContactNumber text field empty
						txtCompany.setText("");//Setting txtCompany text field empty
						txtSalary.setText("");//Setting txtSalary text field empty
						txtBirthDay.setText("");//Setting txtBirthDay text field empty
					}else{
						txtContactId.setText(contact.getContactId());
						txtName.setText(contact.getName());
						txtContactNumber.setText(contact.getPhoneNumber());
						txtCompany.setText(contact.getCompany());
						txtSalary.setText(String.valueOf(contact.getSalary())); //String.valueOf()---> converting double to string
						txtBirthDay.setText(contact.getBirthDay());
					}
				}catch(IOException ex){
					//
				}
			}
		});
		
		btnBackToHomePage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
	}
}
