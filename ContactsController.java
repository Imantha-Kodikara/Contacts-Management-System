import java.io.*;
public class ContactsController{
	public static boolean addContact(Contact contact) throws IOException{
		FileWriter fw = new FileWriter("Contacts.txt", true);
		fw.write(contact.toString()+"\n"); // to write contact details to the text file. \n used to move to the next line
		fw.close(); // close the file
		return true;
	}
	
}
