import java.util.*;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class ListByName extends JFrame{
	private JPanel northPanel;
	private JPanel southPanel;
	
	private JLabel lblHeader;
	
	private JButton btnReload;
	private JButton btnGoBack;
	
	private JTable tblContacts;
	private DefaultTableModel dtm;
	
	ListByName(){
		setSize(700, 500);
		setTitle("List By name");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
		
		northPanel = new JPanel(new BorderLayout(10,10));//Creating a JPanel to add header label and contct Id
		
		lblHeader = new JLabel("LIST CONTACTS BY NAME", JLabel.CENTER);
		lblHeader.setFont(new Font("", 1, 24));
		lblHeader.setOpaque(true);
		lblHeader.setBackground(new Color(173, 216, 230));
		
		northPanel.add("North", lblHeader); //lblHeader adding to the North of North Panel	
		
		add("North",northPanel);
		
		southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,10, 10));
		
		btnReload = new JButton("Reload");
		btnReload.setFont(new Font("", 1, 18));
		southPanel.add(btnReload);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("", 1, 18));
		southPanel.add(btnGoBack);
		
		add("South", southPanel);
		
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				List contactsList = ContactsDB.getInstance().getContactsList();
				//Creating temporary contacts array to sort by name
			
				Contact[] tempContactsArray = new Contact[contactsList.size()];
	
				//Copying the elements to contacts array to the temporary contacts array
			
				for (int i = 0; i < contactsList.size(); i++){
					tempContactsArray[i] = contactsList.get(i);
				}
				
				for (int j = tempContactsArray.length - 1; j >= 0; j--){
					for (int i = 0; i < j; i++){
						if(comparingStrings((tempContactsArray[i].getName()), (tempContactsArray[i+1].getName())) >= 0){
							Contact temp = tempContactsArray[i];
							tempContactsArray[i] = tempContactsArray[i+1];
							tempContactsArray[i+1] = temp;
						}
					}
				}
				
				dtm.setRowCount(0);
				
				for (int i = 0; i < tempContactsArray.length; i++){
					Contact c1 = tempContactsArray[i];
					Object[] rowData={c1.getContactId(),c1.getName(),c1.getPhoneNumber(),c1.getCompany(), c1.getSalary(), c1.getBirthDay()};
					dtm.addRow(rowData);		
				}
			}
		});
		
		String[] columnName={"Contact ID", "Name", "Contact Number", "Company", "Salary", "BirthDay"};
		dtm=new DefaultTableModel(columnName,0);
		tblContacts=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblContacts);
		
		add("Center",tablePane);
		
		btnGoBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					dispose();
			}
		});
	}
	
	//------------------------------------Comparing two strings Method----------------------------------------
	
	private int comparingStrings(String firstElement, String secondElement){
		int comparissonNumber;
		comparissonNumber = firstElement.compareTo(secondElement);
		return comparissonNumber;
	}
}
