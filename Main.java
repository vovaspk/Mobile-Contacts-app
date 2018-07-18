import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone("0039 330 4404");

	public static void main(String[] args) {
	
		
		boolean quit = false;
		
		startPhone();
		printActions();
		while(!quit) {
			System.out.println("Enter action (6 to show available actions)");
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch(action) {
			case 0:
				System.out.println("Shutting down");
				quit = true;
				break;
			case 1:
				mobilePhone.printContacts();
				break;
			case 2:
				addNewContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6:
				printActions();
				break;
				
			}
		}
	}
	
	private static void addNewContact() {
		System.out.println("Enter a new contact name: ");
		String name = scanner.nextLine();
		System.out.println("Enter phone Number: ");
		String phone = scanner.nextLine();
		Contact newContact = Contact.createContact(name, phone);
		
		if(mobilePhone.addNewContact(newContact)) {
			System.out.println("New Contact added name: "
					+ newContact.getName()
					+ ", phone: " + newContact.getPhoneNumber());
		}else {
		System.out.println("Cannot add a contact" + newContact.getName() 
		+ "already exists on file");
		}
	}
	
	private static void updateContact() {
		System.out.println("Enter existing contact name: ");
		String name = scanner.nextLine();
		
		Contact existingContactRecord = mobilePhone.queryContact(name);
		if(existingContactRecord == null) {
			System.out.println("Contact not found");
			return;
		}
		System.out.println("Enter new contact name");
		String newName = scanner.nextLine();
		System.out.println("Enter a new phone number: ");
		String newNumber = scanner.nextLine();
		Contact newContact = Contact.createContact(newName, newNumber);
		if(mobilePhone.updateContact(existingContactRecord, newContact)) {
			System.out.println("Successfully updated record");
		}else {
			System.out.println("fail to update record");
		}
		
	}
	private static void removeContact() {
		System.out.println("Enter existing contact name: ");
		String name = scanner.nextLine();
		
		Contact existingContactRecord = mobilePhone.queryContact(name);
		if(existingContactRecord == null) {
			System.out.println("Contact not found");
			return;
		}
		if(mobilePhone.removeContact(existingContactRecord)) {
			System.out.println("Successfully deleted");
		}else {
			System.out.println("Error deliting record");
		}
	}
	public static void queryContact() {
		System.out.println("Enter existing contact name: ");
		String name = scanner.nextLine();
		
		Contact existingContactRecord = mobilePhone.queryContact(name);
		if(existingContactRecord == null) {
			System.out.println("Contact not found");
			return;
		}
		System.out.println("Name " + existingContactRecord.getName() + " phone number " 
		+ existingContactRecord.getPhoneNumber());
		
	}
	
	private static void startPhone() {	System.out.println("Starting phone");}
	
	private static void printActions() {
		System.out.println("\nAvailable actions:\npress");
		System.out.println("0 - to shut down\n" +
						   "1 - to print contacts\n" + 
						   "2 -  to add a new contact\n" + 
						   "3 - to update existing contact\n" + 
						   "4 - to remove existing contact\n" +
						   "5 - query if existing contact exist\n" +
						   "6 - to print a list of available actions\n"
				);
		System.out.println("Choose your action: ");
	}
	
	
	
	
	
	
	
	
	

}
