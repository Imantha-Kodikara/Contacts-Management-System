import java.util.*;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class DeleteContact extends JFrame{
	private JPanel northPanel;
	private JPanel searchPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	
	private JButton btnSearch;
	private JButton btnBackToHomePage;
	private JButton btnDelete;
	private JButton btnCancel;
	
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
	
	DeleteContact(){
		setSize(700, 500);
		setTitle("Delete Contact");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
		
		northPanel = new JPanel(new BorderLayout(10,10));//Creating a JPanel to add header label and contct Id
		
		lblHeader = new JLabel("DELETE CONTACT", JLabel.CENTER);
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
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("", 1, 18));
		southPanel.add(btnDelete);
		
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
				Contact contact = new Contact(null, nameOrContactNumber, nameOrContactNumber, null, 0.0, null);
				List contactsList = ContactsDB.getInstance().getContactsList();
				int index = contactsList.indexOf(contact);
				
				if(index == -1){
					JOptionPane.showMessageDialog(null,nameOrContactNumber+" is not exists...");
					txtSearch.setText("");
				}else{
					Contact c1 = contactsList.get(index);
					txtContactId.setText(c1.getContactId());
					txtName.setText(c1.getName());
					txtContactNumber.setText(c1.getPhoneNumber());
					txtCompany.setText(c1.getCompany());
					txtSalary.setText(String.valueOf(c1.getSalary())); //String.valueOf()---> converting double to string
					txtBirthDay.setText(c1.getBirthDay());
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String nameOrContactNumber = txtSearch.getText();
				List contactsList = ContactsDB.getInstance().getContactsList();
				Contact contact = new Contact(null, nameOrContactNumber, nameOrContactNumber, null, 0.0, null);
				int index = contactsList.indexOf(contact);
				
				if(index == -1){
					JOptionPane.showMessageDialog(null,nameOrContactNumber+"No contact available for deletion...");
					txtSearch.setText("");
				}else{
					int option = JOptionPane.showConfirmDialog(null, "Do you want to proceed with this Deletion ?", "Confirmation", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION){
						contactsList.remove(index);
						
						JOptionPane.showMessageDialog(null,"Contact Deleted Successfully...");
						
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
	}
}
