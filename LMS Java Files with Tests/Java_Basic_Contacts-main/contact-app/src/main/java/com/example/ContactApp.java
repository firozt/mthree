package com.example;

import java.util.Scanner;

public class ContactApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] contacts = new String[100];

    public static void main(String[] args) {

        int count = 0;

        while (true) {
            System.out.println("Contact Application");

            System.out.println();

            System.out.println("1. Create a contact");
            System.out.println("2. Get a contact");
            System.out.println("3. Update a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Retrieve all contacts");
            System.out.println("6. Exit contact app");

            System.out.println();
            System.out.print("Enter your choice (1-6): ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    String firstName = promptMessage("Enter contact's first name: ");
                    String lastName = promptMessage("Enter contact's last name: ");
                    String company = promptMessage("Enter contact's company: ");
                    String email = promptMessage("Enter contact's email: ");
                    String phone = promptMessage("Enter contact's phone: ");

                    String contact = createContact(count, firstName, lastName, company, email, phone);
                    count++;
                    break;
                case 2:
                    int contactId = Integer.parseInt(promptMessage("Enter contact's id to create: "));
                    String contactInfo = getContact(contactId);
                    System.out.println(contactInfo);
                    break;
                case 3:
                    contactId = Integer.parseInt(promptMessage("Enter contact's id to update: "));
                    String property = promptMessage(
                            "Enter the property of contact to update (company, email, phone): ");
                    String value = promptMessage("Enter new " + property + " for contact: ");
                    updateContact(contactId, property, value);
                    break;
                case 4:
                    contactId = Integer.parseInt(promptMessage("Enter contact's id to delete: "));
                    deleteContact(contactId);
                    break;
                case 5:
                    getAllContacts();
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.err.println("Please select choice between 1 and 6");
                    break;
            }

            System.out.println();
        }
    }

    public static String createContact(int index, String firstName, String lastName, String company, String email,
            String phone) {
        /*
         * PLEASE INSERT YOUR CODE STRICTLY BETWEEN BELOW COMMENTED LINES
         * YOUR CODE STARTS HERE
         * YOUR CODE ENDS HERE
         * AS TEST CASES ARE EXECUTED USING AUTOMATION TECHNIQUE, REQUEST TO
         * STRICTLY FOLLOW BELOW MENTIONED RULES
         * 1. THE REST OF THE CODE PROVIDED TO YOU SHOULD BE KEPT STRICTLY UNTOUCHED.
         * 2. YOUR OWN CODE WOULD COME ONLY INSIDE ABOVE-MENTIONED PAIR OF COMMENTS.
         * 3. THE CLASS NAMES, INTERFACE NAMES, METHOD SIGNATURES AND ATTRIBUTE NAMES
         * SHOULD NOT BE ALTERED OR MODIFIED AND KEPT STRICTLY UNTOUCHED.
         * 4. PLEASE FOLLOW STANDARD JAVA NAMING CONVENTIONS FOR THE PIECE OF CODE YOU
         * ARE GOING TO PROVIDE INSIDE THE BELOW-MENTIONED PAIR OF COMMENTS.
         */
    	
    	// Construct a string representation for contact based on given information.
    	// Store the string representation at the index corresponding to contactId in contacts array.
    	// Return the string representation to its caller.
    	// The returned string representation has the form:
    	// contactId::firstName::lastName::company::email::phone
    	
    	// NOTE: contacts array index starts from 0, whereas id of contact starts from 1.
    	// so contactId in the string representation is equal to index + 1
    	String contactString = null;

        //YOUR CODE STARTS HERE
        contactString = String.format("%d::%s::%s::%s::%s::%s",index+1,firstName,lastName,company,email,phone);
        contacts[index+1] = contactString;
        //YOUR CODE ENDS HERE
    	
    	return contactString;
    }

    public static String getContact(int contactId) {
        String contactInfo = null;
        
        /*
         * PLEASE INSERT YOUR CODE STRICTLY BETWEEN BELOW COMMENTED LINES
         * YOUR CODE STARTS HERE
         * YOUR CODE ENDS HERE
         * AS TEST CASES ARE EXECUTED USING AUTOMATION TECHNIQUE, REQUEST TO
         * STRICTLY FOLLOW BELOW MENTIONED RULES
         * 1. THE REST OF THE CODE PROVIDED TO YOU SHOULD BE KEPT STRICTLY UNTOUCHED.
         * 2. YOUR OWN CODE WOULD COME ONLY INSIDE ABOVE-MENTIONED PAIR OF COMMENTS.
         * 3. THE CLASS NAMES, INTERFACE NAMES, METHOD SIGNATURES AND ATTRIBUTE NAMES
         * SHOULD NOT BE ALTERED OR MODIFIED AND KEPT STRICTLY UNTOUCHED.
         * 4. PLEASE FOLLOW STANDARD JAVA NAMING CONVENTIONS FOR THE PIECE OF CODE YOU
         * ARE GOING TO PROVIDE INSIDE THE BELOW-MENTIONED PAIR OF COMMENTS.
         */

        // Find the contact information in contacts array whose contact id is equal to 
        // the value of contactId parameter.

        // The returned contact information has the form:
        // "contact name: firstName lastName, contact company: companyName, contact email: email, contact phone: phone"

        // Example
        // If contacts array have a contact string representation as '2::Ada::Lovelace::Babbage Industries::ada@example.com::424-1337'
        // When calling getContact(2), returned contact Info should be 
        // "contact name: Ada Lovelace, contact company: Babbage Industries, contact email: ada@example.com, contact phone: 424-1337"


        for (String contact : contacts) {
            if (contact != null && !contact.equals("")) {
        //YOUR CODE STARTS HERE
                String[] contactStringArr = contact.split("::");
                int id = Integer.parseInt(contactStringArr[0]);
                if (id == contactId) {
                    String fullname = contactStringArr[1] + ' ' + contactStringArr[2];
                    return String.format(
                            "contact name: %s, contact company: %s, contact email: %s, contact phone: %s",
//                            contact name: Ada Lovelace, contact company: Babbage Industries, contact email: ada@example.com, contact phone: 424-1337
                            fullname,
                            contactStringArr[3],
                            contactStringArr[4],
                            contactStringArr[5]
                    );
                }



        //YOUR CODE ENDS HERE
            }
        }

        return contactInfo;
    }

    public static String updateContact(int contactId, String property, String value) {
        String contact = null;
        /*
         * PLEASE INSERT YOUR CODE STRICTLY BETWEEN BELOW COMMENTED LINES
         * YOUR CODE STARTS HERE
         * YOUR CODE ENDS HERE
         * AS TEST CASES ARE EXECUTED USING AUTOMATION TECHNIQUE, REQUEST TO
         * STRICTLY FOLLOW BELOW MENTIONED RULES
         * 1. THE REST OF THE CODE PROVIDED TO YOU SHOULD BE KEPT STRICTLY UNTOUCHED.
         * 2. YOUR OWN CODE WOULD COME ONLY INSIDE ABOVE-MENTIONED PAIR OF COMMENTS.
         * 3. THE CLASS NAMES, INTERFACE NAMES, METHOD SIGNATURES AND ATTRIBUTE NAMES
         * SHOULD NOT BE ALTERED OR MODIFIED AND KEPT STRICTLY UNTOUCHED.
         * 4. PLEASE FOLLOW STANDARD JAVA NAMING CONVENTIONS FOR THE PIECE OF CODE YOU
         * ARE GOING TO PROVIDE INSIDE THE BELOW-MENTIONED PAIR OF COMMENTS.
         */
        
        // Iterator contacts array to find contact string representation whose contact
        // id is equal to the value of contactId parameter.
        
        for (String c : contacts) {
            if (c != null && !c.equals("")) {
        //YOUR CODE STARTS HERE
                String[] contactStringArr = c.split("::");
                int id = Integer.parseInt(contactStringArr[0]);
                if (id == contactId) {
                    int idxToChange = -1;
                    switch (property) {
                        case "firstname":
                            idxToChange = 1;
                            break;
                        case "lastname":
                            idxToChange = 2;
                            break;
                        case "company":
                            idxToChange = 3;
                            break;
                        case "email":
                            idxToChange = 4;
                            break;
                        case "phone":
                            idxToChange = 5;
                            break;
                    }
                    contactStringArr[idxToChange] = value;
                    String fullname = contactStringArr[1] + ' ' + contactStringArr[2];
                    return String.format(
                            "contact name: %s, contact company: %s, contact email: %s, contact phone: %s",
                            fullname,
                            contactStringArr[3],
                            contactStringArr[4],
                            contactStringArr[5]
                    );

                }
        //YOUR CODE ENDS HERE
                
            }
        }
        
        if (contact == null) {
            return "No contact with contactId " + contactId + " found.";
        }

        String[] parts = contact.split("::");
        String updated = "contact name: " + parts[1] + " " + parts[2] + ", contact company: " + parts[3]
                + ", contact email: " + parts[4] + ", contact phone: " + parts[5];
        
        // Update contact information according the property name and property value.
        
        switch (property) {
      //YOUR CODE STARTS HERE
            
       //YOUR CODE ENDS HERE
        }
        return updated;
    }

    public static boolean deleteContact(int contactId) {
        boolean deleted = false;
        /*
         * PLEASE INSERT YOUR CODE STRICTLY BETWEEN BELOW COMMENTED LINES
         * YOUR CODE STARTS HERE
         * YOUR CODE ENDS HERE
         * AS TEST CASES ARE EXECUTED USING AUTOMATION TECHNIQUE, REQUEST TO
         * STRICTLY FOLLOW BELOW MENTIONED RULES
         * 1. THE REST OF THE CODE PROVIDED TO YOU SHOULD BE KEPT STRICTLY UNTOUCHED.
         * 2. YOUR OWN CODE WOULD COME ONLY INSIDE ABOVE-MENTIONED PAIR OF COMMENTS.
         * 3. THE CLASS NAMES, INTERFACE NAMES, METHOD SIGNATURES AND ATTRIBUTE NAMES
         * SHOULD NOT BE ALTERED OR MODIFIED AND KEPT STRICTLY UNTOUCHED.
         * 4. PLEASE FOLLOW STANDARD JAVA NAMING CONVENTIONS FOR THE PIECE OF CODE YOU
         * ARE GOING TO PROVIDE INSIDE THE BELOW-MENTIONED PAIR OF COMMENTS.
         */
        for (int i = 0; i < contacts.length; i++) {
            String contact = contacts[i];
            if (contact != null && !contact.equals("")) {
       // If the contact with given contactId is found.
       // Please set the index of this contact in contacts array to null 
       // to indicate this contact is deleted.
       //YOUR CODE STARTS HERE
                String[] contactStringArr = contact.split("::");
                int id = Integer.parseInt(contactStringArr[0]);
                if (id == contactId) {
                    contacts[id-1] = null;
                    return true;
                }
       //YOUR CODE ENDS HERE
            }
        }
        
        return deleted;
    }

    public static void getAllContacts() {
        for (String contact : contacts) {
            if (contact != null && !contact.equals("")) {
                String[] parts = contact.split("::");
                System.out.println("contact name: " + parts[1] + " " + parts[2] + ", contact company: " + parts[3]
                        + ", contact email: " + parts[4] + ", contact phone: " + parts[5]);
            }
        }
    }

    public static String promptMessage(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int countContacts() {
        int count = 0;
        for (String contact : contacts) {
            if (contact != null && !contact.equals("")) {
                count++;
            }
        }
        return count;
    }

}
