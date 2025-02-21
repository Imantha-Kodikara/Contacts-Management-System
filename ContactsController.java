import java.io.*;
public class ContactsController{
	
	//---------------------------addContact method----------------------------------
	
	public static boolean addContact(Contact contact) throws IOException{
		FileWriter fw = new FileWriter("Contact.txt", true);
		fw.write(contact.toString()+"\n");
		fw.close();
		return true;
	}
	
	//----------------------------getAllContacts method-----------------------------
	
	public static List getAllContacts() throws IOException{
		List contactsList = new List();
		FileReader fr = new FileReader("Contact.txt");
		BufferedReader br = new BufferedReader(fr);
			
		String line = br.readLine();
		while (line != null){
			String [] rowData = line.split(",");
			String contactId = rowData[0];
			String name = rowData[1];
			String contactNumber = rowData[2];
			String company = rowData[3];
			double salary = Double.parseDouble(rowData[4]);
			String birthDay = rowData[5];
				
			Contact contact = new Contact(contactId, name, contactNumber, company, salary, birthDay);
				contactsList.add(contact);
				line = br.readLine();
		}
		return contactsList;
	}
	
	//------------------------------lastContact method-----------------------------------
	
	public static Contact lastConact() throws IOException{
		List contactsList = getAllContacts();
		return contactsList.size() == 0 ? null : contactsList.get(contactsList.size()-1);
	}
	
	//--------------------------------searchContact method-------------------------------
	
	public static Contact searchContact(String nameOrContactNumber) throws IOException{
		List contactsList = getAllContacts();
		for (int i = 0; i < contactsList.size(); i++){
			Contact contact = contactsList.get(i);
			if(contact.equals(new Contact(null, nameOrContactNumber, nameOrContactNumber, null, 0.0, null))){
				return contact;
			}
		}
		return null;
	}
	
	//---------------------------------updateContact method--------------------------------
	
	public static boolean updateContact(Contact contact) throws IOException{
		List contactsList = getAllContacts();
		int index = contactsList.indexOf(contact);
		if(index == -1){
			return false;
		}
		contactsList.set(index, contact);
		
		FileWriter fw = new FileWriter("Contact.txt");
		for (int i = 0; i < contactsList.size(); i++){
			fw.write(contactsList.get(i).toString()+"\n");
		}
		fw.close();
		return true;
	}
	
	//----------------------------------deleteContact method----------------------------------
	
	public static boolean deleteContact(Contact contact) throws IOException{
		List contactsList = getAllContacts();
		int index = contactsList.indexOf(contact);
		if(index == -1){
			return false;
		}
		contactsList.remove(index);
		
		FileWriter fw = new FileWriter("Contact.txt");
		for (int i = 0; i < contactsList.size(); i++){
			fw.write(contactsList.get(i).toString()+"\n");
		}
		fw.close();
		return true;
	}
}
