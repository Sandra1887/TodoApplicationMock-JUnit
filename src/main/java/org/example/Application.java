package org.example;

import java.sql.SQLException;

public class Application {
    ToDo todo;
    DbHandler dbHandler;
    Helper helper;
    boolean exit = false;

    public Application() throws SQLException {
        helper = new Helper();
        String dbName = helper.askForDbName();
        dbHandler = new DbHandler(dbName);
    }
    public void start() throws SQLException {
        while (!exit) {
            switch (helper.mainMenu()) {
                case 1 -> {
                    dbHandler.create();
                    break;
                }
                case 2 -> {
                    dbHandler.read();
                    break;
                }
                case 3 -> {
                    dbHandler.updateText();
                    break;
                }
                case 4 -> {
                    dbHandler.updateDone();
                }
                case 5 -> {
                    dbHandler.delete();
                }
                case 6 -> {
                    exit = true;
                }
            }
        }
    }
}