public class List{
	private Node first;
	
	public List(){
		first = null;
	}
	//----------------------------------------addContact method--------------------------------
	
	public void add(Contact contact){
		addLast(contact);//pasing the contact object to the addLast method.
	}
	
	//-----------------------------------------addLast method----------------------------------
	
	public void addLast(Contact contact){
		Node n1 = new Node(contact);
		if(first == null){
			first = n1;
		}else{
			Node temp = first;//creating temporary variable and assign first node to that temporary variable
			while (temp.next != null){
				temp = temp.next;
			}
			temp.next = n1;
		}
	}
	
	//-----------------------------------------addFirst method---------------------------------
	
	public void addFirst(Contact contact){
		Node n1 = new Node(contact);
		n1.next = first;
		first = n1;
	}
	
	//-----------------------------------------size method-------------------------------------
	
	public int size(){
		int count = 0;
		Node temp = first;
		while (temp != null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	//------------------------------------------isEmpty method----------------------------------
	
	public boolean isEmpty(){
		return first == null;
	}
	
	//---------------------------------------add(index, contact) method------------------------
	
	public boolean add(int index, Contact contact){
		if(index >=0 && index <= size()){
			if(index == 0){
				addFirst(contact);
			}else{
				Node n1 = new Node(contact);
				Node temp = first;
				int i = 0;
				while (i < index - 1){
					temp = temp.next;
					i++;
				}
				n1.next = temp.next;
				temp.next = n1;
				return true;
			}
		}
		return false;
	}
	
	//----------------------------------remove method-----------------------------------------
	
	public boolean remove(int index){
		if(index >= 0 && index < size() && !isEmpty()){
			if(index == 0){
				first = first.next;
				return true;
			}else{
				int i = 0;
				Node temp = first;
				while (i < index - 1){
					temp = temp.next;
					i++;
				}
				temp.next = temp.next.next;
				return true;
			}
		}
		return false;
	}
	
	//-----------------------------------get method-------------------------------------------
	
	public Contact get(int index){
		if(index >= 0 && index < size() && !isEmpty()){
			int i = 0;
			Node temp = first;
			while (i < index){
				temp = temp.next;
				i++;
			}
			return temp.contact;
		}
		return null;
	}
	
	//-----------------------------------set method-----------------------------------------
	
	public boolean set(int index, Contact contact){
		if(index >= 0 && index < size() && !isEmpty()){
			int i = 0;
			Node temp = first;
			while (i < index){
				temp = temp.next;
				i++;
			}
			temp.contact = contact;
			return true;
		}
		return false;
	}
	
	//-----------------------------------printList method--------------------------------------
	
	public void printList(){
		System.out.println(toString());
	}
	
	//------------------------------------toString method-------------------------------------
	
	public String toString(){
		String list = "{";
		Node temp = first;
		while (temp != null){
			list += temp.contact+", ";
			temp = temp.next;
		}
		return isEmpty() ? "{empty}" : list+"\b\b}";
	}
	
	//------------------------------------remove method--------------------------------------
	
	public void remove(Contact contact){
		indexOf(contact);
	}
	
	//-------------------------------------indexOf method-------------------------------------
	
	public int indexOf(Contact contact){
		int index = 0;
		Node temp = first;
		while (temp != null){
			if(temp.contact.equals(contact)){
				return index;
			}
			index++;
			temp = temp.next;
		}
		return -1;
	}
	
	//------------------------------------toArray method---------------------------------------
	
	public Contact [] toArray(){
		Node temp = first;
		Contact [] contactsArray = new Contact[size()];
		for (int i = 0; i < size(); i++){
			contactsArray[i] = temp.contact;
			temp = temp.next;
		}
		return contactsArray;
	}
	
	//-------------------------Class Node (Inner Class)-----------------------------
	
	class Node{
		private Contact contact;
		private Node next;
		
		Node(Contact contact){
			this.contact = contact;
		}
	}

}
