package Controller;

import DAO.ClassRosterDAO;
import DAO.ClassRosterDAOImpl;
import UI.ClassRosterView;
import UI.UserIOConsoleImpl;

public class ClassRosterController {
    ClassRosterDAO dao;
    ClassRosterView view;

    ClassRosterController(ClassRosterDAO dao) {
        this.view = new ClassRosterView(new UserIOConsoleImpl());
        this.dao = dao;
    }

    public static void main(String[] args) {
        int input = -1;

        while (input != 5) {
            input = view.getView().
        }
    }



}
