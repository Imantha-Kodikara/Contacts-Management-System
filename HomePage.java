import java.util.*;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class HomePage extends JFrame{
	private ImagePanel image;
	private JPanel homePageRightPanel;
	private JPanel centerButtonPanel;
	private JButton btnAddNewContact;
	private JButton btnUpdateContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact;
	private JButton btnViewContact;
	private JButton btnExit;
	HomePage(){
		setSize(700, 500);
		setTitle("Home Page");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		
		image = new ImagePanel("D:\\iCET\\iCM 114\\OOP\\Courseworks\\Coursework 02\\image.jpg");//Set image path
		add(image);//add image to the homepage(left column)
		
		//Creating homepage label
		
		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setFont(new Font("",1,50));
		lblHomePage.setHorizontalAlignment(JLabel.CENTER);
		
		//Creating Center buttons and adding them in to centerButtonPanel
		
		btnAddNewContact = new JButton("Add New Contact");
		btnAddNewContact.setFont(new Font("",1,16));
		
		btnUpdateContact = new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("",1,16));
		
		btnSearchContact = new JButton("Search Contact");
		btnSearchContact.setFont(new Font("",1,16));
		
		btnDeleteContact = new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("",1,16));
		
		btnViewContact = new JButton("View Contact");
		btnViewContact.setFont(new Font("",1,16));
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("",1,16));
		
		//Set action to the btnAddNewContact Button
		
		btnAddNewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new AddContact().setVisible(true);//Creating new AddContact object
			}
		});
		
		//Set action to the btnUpdateContact Button
		
		btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new UpdateContact().setVisible(true);//Creating new UpdateContact object
			}
		});
		
		//Set action to the btnSearchContact Button
		
		btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SearchContact().setVisible(true);//Creating new SearchContact object
			}
		});
		
		//Set action to the btnDelete Button
		
		btnDeleteContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new DeleteContact().setVisible(true);//Creating new DeleteContact object 
			}
		});
		
		//Set action to the btnViewContact Button
		
		btnViewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ContactsList().setVisible(true);//Creating new ContactsList Object
			}
		});
		
		//Set action to the btnExit Button
		
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();//To shutdown the JVM
			}
		});
		
		centerButtonPanel = new JPanel(new GridLayout(6,1, 0, 10));
		centerButtonPanel.add(btnAddNewContact);
		centerButtonPanel.add(btnUpdateContact);
		centerButtonPanel.add(btnSearchContact);
		centerButtonPanel.add(btnDeleteContact);
		centerButtonPanel.add(btnViewContact);
		centerButtonPanel.add(btnExit);
		
		//Setting the layout of the homePageRigthPanel in to the border layout.
		
		homePageRightPanel = new JPanel(new BorderLayout());
		
		//Adding homePage Label and centerButttonPanel to the homePageRigthPanel(to the north and center)
		
		homePageRightPanel.add("North", lblHomePage);
		homePageRightPanel.add("Center", centerButtonPanel);
		
		//Adding homePageRightPanel to the HomePage
		
		add(homePageRightPanel);		
	}
}
