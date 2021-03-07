package com.company;

import controllers.Controller;
import db.DBManager;
import db.IDBManager;
import repositories.IRepository;
import repositories.Repository;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        IDBManager dbManager = new DBManager();
        IRepository repository = new Repository(dbManager);
        Controller controller = new Controller(repository);
        MyApp app = new MyApp(controller);
        app.appStart();



    }
}
