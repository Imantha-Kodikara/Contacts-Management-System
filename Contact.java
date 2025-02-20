import java.util.*;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class Contact{
	
	//-----------------------creating attributes------------------------------------------
	
	private String contactId;
	private String name;
	private String phoneNumber;
	private String company;
	private double salary;
	private String birthDay;
	
	//-----------------------creating default constructor------------------------------------------
	
	public Contact(){
		
	}
	
	//-----------------------Default constructor overloading---------------------------------------
	
	public Contact(String contactId, String name, String phoneNumber, String company, double salary, String birthDay){
		this.contactId = contactId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.company = company;
		this.salary = salary;
		this.birthDay = birthDay;
	}
	
	//--------------------------Creating setters--------------------------------------------------
	
	public void setContactId(String contactId){
		this.contactId = contactId;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	public void setCompany(String company){
		this.company = company;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
	public void setBirthDay(String birthDay){
		this.birthDay = birthDay;
	}
	
	//---------------------------Creating getters--------------------------------------------------
	
	public String getContactId(){
		return this.contactId;
	}
	public String getName(){
		return this.name;
	}
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	public String getCompany(){
		return this.company;
	}
	public double getSalary(){
		return this.salary;
	}
	public String getBirthDay(){
		return this.birthDay;
	}
	
	//--------------------------------------equals method------------------------------------------------------------
	
	public boolean equals(Contact contact){
		if((this.name.equalsIgnoreCase(contact.getName())) || (this.phoneNumber.equalsIgnoreCase(contact.getPhoneNumber()))){
			return true;
		}
		return false;
	}
	
	//--------------------------------------toString method------------------------------------------------------------
	
	public String toString(){
		return "{"+contactId+", "+name+", "+phoneNumber+", "+company+", "+salary+", "+birthDay+"}"; 
	}
	
	
}
