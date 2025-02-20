import java.util.*;
import java.awt.*;

public class ContactsDB{
	private List contactsList;
	private static ContactsDB contactsDB;
	
	private ContactsDB(){
		contactsList = new List();
	}
	public List getContactsList(){
		return contactsList;
	}
	public static ContactsDB getInstance(){
		if(contactsDB == null){
			contactsDB = new ContactsDB();
		}
		return contactsDB;
	}
}
