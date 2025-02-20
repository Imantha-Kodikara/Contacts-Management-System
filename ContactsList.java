import java.util.*;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class ContactsList extends JFrame{
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel buttonPanel;
	private JPanel southPanel;
	
	private JLabel lblHeader;
	
	private JButton btnListByName;
	private JButton btnListBySalary;
	private JButton btnListByBirthDay;
	private JButton btnCancel;
	
	ContactsList(){
		setSize(700, 500);
		setTitle("Contacts List");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
		
		northPanel = new JPanel(new BorderLayout(10,10));//Creating a JPanel to add header label and contct Id
		
		lblHeader = new JLabel("CONTACTS LIST", JLabel.CENTER);
		lblHeader.setFont(new Font("", 1, 24));
		lblHeader.setOpaque(true);
		lblHeader.setBackground(new Color(173, 216, 230));
		
		northPanel.add("North", lblHeader); //lblHeader adding to the North of North Panel	
		
		add("North",northPanel);
		
		centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10, 10));
		buttonPanel = new JPanel(new GridLayout(3, 1, 10, 50));
		
		btnListByName = new JButton("List By Name");
		btnListByName.setFont(new Font("", 1, 18));
		btnListByName.setPreferredSize(new Dimension(350, 50));
		buttonPanel.add(btnListByName);
		
		btnListBySalary = new JButton("List By Salary");
		btnListBySalary.setFont(new Font("", 1, 18));
		btnListBySalary.setPreferredSize(new Dimension(350, 50));
		buttonPanel.add(btnListBySalary);
		
		btnListByBirthDay = new JButton("List By BirthDay");
		btnListByBirthDay.setFont(new Font("", 1, 18));
		btnListByBirthDay.setPreferredSize(new Dimension(350, 50));
		buttonPanel.add(btnListByBirthDay);
		
		centerPanel.add(buttonPanel);
		add("Center", centerPanel);
		
		southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("", 1, 18));
		southPanel.add(btnCancel);
		
		add("South", southPanel);
		
		btnListByName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					new ListByName().setVisible(true);
			}
		});
		
		btnListBySalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					new ListBySalary().setVisible(true);
			}
		});
		
		btnListByBirthDay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					new ListByBirthDay().setVisible(true);
			}
		});
		
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					dispose();
			}
		});
	}
}
