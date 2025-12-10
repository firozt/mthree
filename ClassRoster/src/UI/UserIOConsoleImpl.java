package UI;

import DTO.StudentDTO;
import Model.Student;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{
    private final Scanner scan = new Scanner(System.in);
    private static final String MENU_SEPERATOR = "==============";


    public void displayMenu() {
        System.out.println(UserIOConsoleImpl.MENU_SEPERATOR);
        System.out.println("1) Add student");
        System.out.println("2) List all students");
        System.out.println("3) Display a student");
        System.out.println("4) Remove student");
        System.out.println(UserIOConsoleImpl.MENU_SEPERATOR);
    }

    @Override
    public int getMenuInput() {
        displayMenu();
        int input = getIntInput("Please Select an option (1-4)");
        return input;
    }

    @Override
    public Student askStudentInfo() {
        String firstName = getStringInput("Enter First Name");
        String lastName = getStringInput("Enter Last Name");
        int id = getIntInput("Enter Student ID");
        return new Student(id,firstName,lastName);
    }


    @Override
    public int getIntInput(String message) {
        System.out.println(message);
        String input = getScan().nextLine();
//        parse input
        int res = -1;
        boolean isValidInput = false;

        while(!isValidInput) {
            try {
                res = Integer.parseInt(input);
                isValidInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please input a number 1-4");
            }
        }

        return res;
    }

    @Override
    public String getStringInput(String message) {
        System.out.println(message);
        return scan.nextLine();
    }

    public Scanner getScan() {
        return scan;
    }


}
