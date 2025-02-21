import java.util.*;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.io.*;

public class AddContact extends JFrame {
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    
    private JLabel lblHeader;
    private JLabel lblContactId;
    private JLabel lblName;
    private JLabel lblContactNumber;
    private JLabel lblCompany;
    private JLabel lblSalary;
    private JLabel lblBirthDay;
    
    private JTextField txtName;
    private JTextField txtContactNumber;
    private JTextField txtCompany;
    private JTextField txtSalary;
    private JTextField txtBirthDay;
    
    private JButton btnAddContact;
    private JButton btnCancel;
    private JButton btnBackToHomePage;
    
    private String contactId;
    

    AddContact() {
		setSize(700, 500);
		setTitle("Add Contact");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
		
		northPanel = new JPanel(new BorderLayout(10,10));//Creating a JPanel to add header label and contct Id
		
		lblHeader = new JLabel("ADD CONTACT", JLabel.CENTER);
		lblHeader.setFont(new Font("", 1, 30));
		lblHeader.setOpaque(true);
		lblHeader.setBackground(new Color(173, 216, 230));//RGB Colors
		
		northPanel.add("North", lblHeader); //lblHeader adding to the North of North Panel
		

		lblContactId = new JLabel("",JLabel.LEFT);//Label allignment --> left
		lblContactId.setFont(new Font("", 1, 25));
		generateContactId();
		northPanel.add("Center", lblContactId);//lblContactId adding to the Center of North Panel
		
		add("North", northPanel); //northPanel adding to the North of main frame
		
		centerPanel = new JPanel(new GridLayout(5, 2, 10, 10));
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("", 1, 18));
		centerPanel.add(lblName);
		txtName = new JTextField();
		txtName.setFont(new Font("", 1, 18));
		
		txtName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnAddContact.setEnabled(false);//Disable the btnAddContact while user fills all the text fields.
			}
		});
		
		centerPanel.add(txtName);
		
		lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("", 1, 18));
		centerPanel.add(lblContactNumber);
		txtContactNumber = new JTextField();
		txtContactNumber.setFont(new Font("", 1, 18));
		
		//-------------------Validating Contact Number--------------------------------------------------
		
		txtContactNumber.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String contactNumber = txtContactNumber.getText();
				
				if(!isValidPhoneNumber(contactNumber)){
					JOptionPane.showMessageDialog(null,"Invalid Contact Number");
					txtContactNumber.setText("");
					txtContactNumber.requestFocus(); //Keep focus on Contact Number field
					txtCompany.setEnabled(false);//Disable the next next field while user fills this text field
					btnAddContact.setEnabled(false);//Disable the btnAddContact while user fills all the text fields.
				}else{
					txtCompany.setEnabled(true);//Enable the next text field
					btnAddContact.setEnabled(false);//Disable the btnAddContact while user fills all the text fields.
				}
			}
		});
		
		centerPanel.add(txtContactNumber);
		
		lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("", 1, 18));
		centerPanel.add(lblCompany);
		txtCompany = new JTextField();
		txtCompany.setFont(new Font("", 1, 18));
		
		txtCompany.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnAddContact.setEnabled(false);//Disable the btnAddContact while user fills all the text fields.
			}
		});
		
		centerPanel.add(txtCompany);
	
		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("", 1, 18));
		centerPanel.add(lblSalary);
		txtSalary = new JTextField();
		txtSalary.setFont(new Font("", 1, 18));
		
		//----------------------Validating Salary---------------------------------------------------------
		
		txtSalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				double salary = Double.parseDouble(txtSalary.getText());
				
				if(!isValidSalary(salary)){
					JOptionPane.showMessageDialog(null,"Invalid Salary");
					txtSalary.setText("");
					txtSalary.requestFocus(); //Keep focus on salary field
					txtBirthDay.setEnabled(false);//Disable the next next field while user fills this text field
					btnAddContact.setEnabled(false);//Disable the btnAddContact while user fills all the text fields.
				}else{
					txtBirthDay.setEnabled(true);//Enable the next next field while user fills this text field
					btnAddContact.setEnabled(false);//Disable the btnAddContact while user fills all the text fields.
				}
			}
		});
		
		centerPanel.add(txtSalary);
		
		lblBirthDay = new JLabel("BirthDay");
		lblBirthDay.setFont(new Font("", 1, 18));
		centerPanel.add(lblBirthDay);
		txtBirthDay = new JTextField();
		txtBirthDay.setFont(new Font("", 1, 18));
		
		//----------------------Validating BirthDay------------------------------------------------------------
		
		txtBirthDay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String birthDay = txtBirthDay.getText();
				
				if(!isValidBirthDay(birthDay)){
					JOptionPane.showMessageDialog(null,"Invalid BirthDay");
					txtBirthDay.setText("");
					txtBirthDay.requestFocus(); //Keep focus on Birthday field
					btnAddContact.setEnabled(false);//Disable the btnAddContact while user fills birthday text field.
				}else{
					btnAddContact.setEnabled(true);//Enable the btnAddContact.
				}
			}
		});
		
		centerPanel.add(txtBirthDay);
		
		add("Center", centerPanel);
		
		southPanel = new JPanel(new FlowLayout());
		
		btnAddContact = new JButton("ADD Contact");
		btnAddContact.setFont(new Font("", 1, 18));
		
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				
				String contactId = lblContactId.getText();
				String name = txtName.getText();
				String contactNumber = txtContactNumber.getText();
				String company = txtCompany.getText();
				double salary = Double.parseDouble(txtSalary.getText());//Converting String to double
				String birthDay = txtBirthDay.getText();
				
				Contact contact = new Contact(contactId, name, contactNumber, company, salary, birthDay);
				
				try{
					boolean isAdded = ContactsController.addContact(contact);//passing the contact object to the ContactsController class to write in to Contact.txt file
				
					if(isAdded){
						JOptionPane.showMessageDialog(null,"Contact Number Saved Successfully...");
				
						generateContactId();//Generate next contact ID
						txtName.setText("");//Setting txtName text field empty
						txtContactNumber.setText("");//Setting txtContactNumber text field empty
						txtCompany.setText("");//Setting txtCompany text field empty
						txtSalary.setText("");//Setting txtSalary text field empty
						txtBirthDay.setText("");//Setting txtBirthDay text field empty
					}
				}catch(IOException ex){
					//
				}
			}
		});
		
		southPanel.add(btnAddContact);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("", 1, 18));
		
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtName.setText("");//Setting txtName text field empty
				txtContactNumber.setText("");//Setting txtContactNumber text field empty
				txtCompany.setText("");//Setting txtCompany text field empty
				txtSalary.setText("");//Setting txtSalary text field empty
				txtBirthDay.setText("");//Setting txtBirthDay text field empty
			}
		});		
		
		southPanel.add(btnCancel);
		
		btnBackToHomePage = new JButton("Back To HomePage");
		btnBackToHomePage.setFont(new Font("", 1, 18));
		
		btnBackToHomePage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();//Close the JFrame(AddContact)
			}
		});		
		
		//Adding actions to the text fields(to move the next field when pressed enter key)
		
		txtName.addActionListener(e -> txtContactNumber.requestFocus());
		txtContactNumber.addActionListener(e -> txtCompany.requestFocus());
		txtCompany.addActionListener(e -> txtSalary.requestFocus());
		txtSalary.addActionListener(e -> txtBirthDay.requestFocus());
		txtBirthDay.addActionListener(e -> btnAddContact.requestFocus());
		
		southPanel.add(btnBackToHomePage);
		
		add("South", southPanel);
    }
    
    //---------------------------------------------------Is valid phone number Method-------------------------
	
	private boolean isValidPhoneNumber(String phoneNumber){
		return phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0';
			
	}
	
	//-----------------------------------------------------Is valid salary Method-----------------------------
	
	private boolean isValidSalary(double salary){
		return salary >= 0;
	}
	
	//-----------------------------------Is valid birthday Method---------------------------------------------
	
    private boolean isValidBirthDay(String birthDay){

		if(birthDay.length() != 10){
			return false;
		}
		if(birthDay.charAt(4) != '-' || birthDay.charAt(7) != '-'){
			return false;
		}
		
		String yearInString = birthDay.substring(0,4);
		String monthInString = birthDay.substring(5,7);
		String dayInString = birthDay.substring(8,10);
		
		int yearInInt = Integer.parseInt(yearInString);
		int monthInInt = Integer.parseInt(monthInString);
		int dayInInt = Integer.parseInt(dayInString);
		
		if(monthInInt < 1 || monthInInt > 12){
			return false;
		}
		if(dayInInt > 31 || dayInInt < 1){
			return false;
		}
		
		String todayDate = LocalDate.now().toString();
		String todayDateYearInString = todayDate.substring(0,4);
		String todayDateMonthInString = todayDate.substring(5,7);
		String todayDateDayInString = todayDate.substring(8,10);
		
		int todayDateYearInInt = Integer.parseInt(todayDateYearInString);
		int todayDateMonthInInt = Integer.parseInt(todayDateMonthInString);
		int todayDateDayInInt = Integer.parseInt(todayDateDayInString);
		
		if(yearInInt > todayDateYearInInt){
			return false;
		}
		if((yearInInt == todayDateYearInInt) && (monthInInt > todayDateMonthInInt)){
			return false;
		}
		if((yearInInt == todayDateYearInInt) && (monthInInt == todayDateMonthInInt) && (dayInInt > todayDateDayInInt)){
			return false;
		}
		if(isLeapYear(yearInInt) == false && monthInInt == 2 && dayInInt > 28){
			return false;
		}
		if(getDatesOfMonths(monthInInt) < dayInInt){
			return false;
		}
		
		return true;
	}
	
	//-----------------------------------Is leap year Method--------------------------------------------------
	
    private boolean isLeapYear(int year){
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
			return true;
		}
		return false;
	}
	
	//---------------------------------------Get Dates of Months Method---------------------------------------
	
	private int getDatesOfMonths(int month){
		int actualNumberOfDates = 0;
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				actualNumberOfDates = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				actualNumberOfDates = 30;
				break;
			case 2:
				actualNumberOfDates = 29;	
		}
		return actualNumberOfDates;
	}
	

	//--------------------------------------------Generate Contact ID Method--------------------------------------------------
	
	private void generateContactId(){
		try{
			Contact lastContact = ContactsController.lastConact();
			if(lastContact == null){
				lblContactId.setText("C0001");//Setting the contact ID as C0001
			}else{
				String lastId = lastContact.getContactId();
				int lastIdNumber = Integer.parseInt(lastId.substring(1));
				String newContactId = String.format("C%04d", (lastIdNumber + 1));
						
				//String id = String.format("C%04d",contactsList.size() + 1);//Creating contact id with four digits using current contactsIdArray length
				lblContactId.setText(newContactId);//Setting the contact ID
			}
		}catch(IOException ex){	
			//
		}
	}
}
