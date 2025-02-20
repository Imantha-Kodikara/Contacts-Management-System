import java.util.*;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class UpdateContact extends JFrame{
	private JPanel northPanel;
	private JPanel searchPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	
	private JButton btnSearch;
	private JButton btnUpdate;
	private JButton btnCancel;
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
	
	UpdateContact(){
		setSize(700, 500);
		setTitle("Update Contact");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
		
		northPanel = new JPanel(new BorderLayout(10,10));//Creating a JPanel to add header label and contct Id
		
		lblHeader = new JLabel("UPDATE CONTACT", JLabel.CENTER);
		lblHeader.setFont(new Font("", 1, 24));
		lblHeader.setOpaque(true);
		lblHeader.setBackground(new Color(173, 216, 230));//RGB Values
		
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
		centerPanel.add(txtContactId);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("", 1, 18));
		centerPanel.add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("", 1, 18));
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
				}
			}
		});
		
		centerPanel.add(txtContactNumber);
		
		lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("", 1, 18));
		centerPanel.add(lblCompany);
		
		txtCompany = new JTextField();
		txtCompany.setFont(new Font("", 1, 18));
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
				}
			}
		});
		
		centerPanel.add(txtBirthDay);
		
		add("Center", centerPanel);
		
		southPanel = new JPanel(new FlowLayout());
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("", 1, 18));
		southPanel.add(btnUpdate);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("", 1, 18));
		southPanel.add(btnCancel);
		
		btnBackToHomePage = new JButton("Back To Home Page");
		btnBackToHomePage.setFont(new Font("", 1, 18));
		southPanel.add(btnBackToHomePage);
		add("South", southPanel);
		
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String nameOrContactNumber = txtSearch.getText();
				List contactsList = ContactsDB.getInstance().getContactsList();
				Contact contact = new Contact(null, nameOrContactNumber, nameOrContactNumber, null, 0.0, null);
				
				int index = contactsList.indexOf(contact);
				
				if(index == -1){
					JOptionPane.showMessageDialog(null,nameOrContactNumber+" is not exists...");
					txtSearch.setText("");
				}else{
					Contact c1 = contactsList.get(index);
					txtContactId.setText(c1.getContactId());
					txtContactId.setEditable(false); //Not allowed to edit contact id
					txtName.setText(c1.getName());
					txtContactNumber.setText(c1.getPhoneNumber());
					txtCompany.setText(c1.getCompany());
					txtSalary.setText(String.valueOf(c1.getSalary())); //String.valueOf()---> converting double to string
					txtBirthDay.setText(c1.getBirthDay());
				}
			}
		});
		
		btnUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String nameOrContactNumber = txtSearch.getText();
				List contactsList = ContactsDB.getInstance().getContactsList();
				Contact contact = new Contact(null, nameOrContactNumber, nameOrContactNumber, null, 0.0, null);
				
				int index = contactsList.indexOf(contact);
				
				if(index == -1){
					JOptionPane.showMessageDialog(null,nameOrContactNumber+"Cannot update empty contact...");
					txtSearch.setText("");
				}else{
					int option = JOptionPane.showConfirmDialog(null, "Do you want to proceed with this Update ?", "Confirmation", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION){
						String contactId = txtContactId.getText();
						String name = txtName.getText();
						String phoneNumber = txtContactNumber.getText();
						String company = txtCompany.getText();
						double salary = Double.parseDouble(txtSalary.getText());
						String birthDay = txtBirthDay.getText();
						
						Contact c1 = new Contact(contactId, name, phoneNumber, company, salary, birthDay);
						contactsList.set(index, c1);
						
						JOptionPane.showMessageDialog(null,"Contact Updated Successfully...");
						
						txtContactId.setText("");
						txtName.setText("");
						txtContactNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthDay.setText("");
					}else{
						txtContactId.setText("");
						txtName.setText("");
						txtContactNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthDay.setText("");
					}
				}
				
			}
		});
		
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					txtContactId.setText("");
					txtName.setText("");
					txtContactNumber.setText("");
					txtCompany.setText("");
					txtSalary.setText("");
					txtBirthDay.setText("");
			}
		});
		
		btnBackToHomePage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		
		//Adding actions to the text fields(to move the next field when pressed enter key)
		
		txtName.addActionListener(e -> txtContactNumber.requestFocus());
		txtContactNumber.addActionListener(e -> txtCompany.requestFocus());
		txtCompany.addActionListener(e -> txtSalary.requestFocus());
		txtSalary.addActionListener(e -> txtBirthDay.requestFocus());
		txtBirthDay.addActionListener(e -> btnUpdate.requestFocus());
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
}
