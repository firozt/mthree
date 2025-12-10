package UI;

import Model.Student;

public interface UserIO {

    public int getMenuInput();

    public Student askStudentInfo();

    public int getIntInput(String message);

    public String getStringInput(String message);
}