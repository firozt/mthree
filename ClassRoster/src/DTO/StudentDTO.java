package DTO;

public class StudentDTO {
    private int ID;
    private String firstName;
    private String lastName;


    public StudentDTO(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

}
