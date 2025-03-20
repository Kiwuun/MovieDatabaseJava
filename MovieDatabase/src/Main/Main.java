// Name: Deven Schmidt

package Main;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.security.Key;

import keyboard.keyboardInput;
import database.Database;
import movie.Movie;

public class Main {
    public static void main(String[] args) {
        keyboardInput keyboard = new keyboardInput();
        String input;
        boolean status = true;

        Database database = new Database("db.txt");
        
        System.out.println("Movie Database Management LLC");
        System.out.println("-----------------------------");

        while(status) {
            display();
            input = keyboard.getKeyboardLine();
            checkInput(input, keyboard, database);
        }
    }

    public static void checkInput(String input, keyboardInput keyboard, Database database) {
        switch(input) {
            case "quit":
                keyboard.closeKeyboard();
                System.exit(0);
                break;
            case "new entry":
                database.addEntry(handleNewEntry(keyboard));
                break;
            case "search by actor":
                database.searchByActor(handleStringSearch("actor", keyboard));
                break;
            case "search by year":
                database.searchByYear(handleIntSearch("year", keyboard));
                break;
            case "search by runtime":
                database.searchByRuntime(handleIntSearch("runtime", keyboard));
                break;
            case "search by director":
                database.searchByDirector(handleStringSearch("director", keyboard));
                break;
            case "search by title":
                database.searchByTitle(handleStringSearch("title", keyboard));
                break;
        }
    }

    public static void display() {
        System.out.println("Enter command:");
        System.out.println("a.) new entry");
        System.out.println("b.) search by actor");
        System.out.println("c.) search by year");
        System.out.println("d.) search by runtime (in minutes)");
        System.out.println("e.) search by director");
        System.out.println("f.) search by title");
        System.out.println("g.) quit");
    }


    public static Movie handleNewEntry(keyboardInput keyboard) {
        System.out.print("Enter title > \n");
        String title = keyboard.getKeyboardLine();
        title = getTitle(title, keyboard);

        System.out.println("Enter year >");
        int year;
        try {
        	year = Integer.parseInt(keyboard.getKeyboardLine());
        } catch (NumberFormatException e) {
        	year = 0;
        }

        System.out.println("Enter runtime >");
        int runtime;
        try {
        	runtime = Integer.parseInt(keyboard.getKeyboardLine());
        } catch (NumberFormatException e) {
        	runtime = 0;
        }

        System.out.println("Enter actor 1 >");
        String actor1 = keyboard.getKeyboardLine();
        
        if(actor1.length() == 0) {
        	actor1 = "null";
        }

        System.out.println("Enter actor 2");
        String actor2 = keyboard.getKeyboardLine();

        if(actor2.length() == 0) {
        	actor2 = "null";
        }
        
        System.out.println("Enter Director >");
        String director = keyboard.getKeyboardLine();
        
        if(director.length() == 0) {
        	director = "null";
        }

        System.out.println("Movie Added");

        Movie movie = new Movie(title, actor1, actor2, director, year, runtime);
        return movie;
    }

    public static int handleIntSearch(String type, keyboardInput keyboard) {
       System.out.println("Search by " + type + " >");
       int output = Integer.parseInt(keyboard.getKeyboardLine());
       return output;
    }

    public static String handleStringSearch(String type, keyboardInput keyboard) {
        System.out.println("Search by " + type + " >");
        String output = keyboard.getKeyboardLine().toLowerCase();
        return output;
    }
    
    private static String getTitle(String title, keyboardInput keyboard) {	 
    	 if(title.length() < 3) {
    		 System.out.println("Title must be atleast 3 characters");
    		 System.out.print("Enter title > \n");
    		 String newTitle = keyboard.getKeyboardLine();
    		 return getTitle(newTitle, keyboard);
    	 }
    	 
    	 return title;
    }
}