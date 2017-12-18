package com.schoolofnet.Java_Jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	
    public static void main( String[] args ) throws SQLException {
    	Scanner scanner = new Scanner(System.in);
    	
    	MovieDAO dao = new MovieDAO();

    	System.out.println("------------ Menu ------------");
    	System.out.println("1 - List movies");
    	System.out.println("2 - Create new movie");
    	System.out.println("3 - Update a movie");
    	System.out.println("4 - Delete a movie");
    	System.out.println("------------ Menu ------------");
    	
    	int choice = scanner.nextInt();
    	
    	switch(choice) {
    		case 1:
    			ArrayList<Movie> data = (ArrayList<Movie>) dao.findAll();
    			
    			for (Movie movie : data) {
    				System.out.println("Id: " + movie.getId());
    				System.out.println("Name: " + movie.getName());
    			}
    		break;
    		case 2:
    			System.out.println("Enter name:");
    			String name = scanner.next();
    			dao.insert(new Movie(name));
    		break;
    		case 3:
    			System.out.println("Enter Movie Id: ");
    			Integer id = scanner.nextInt();
    			
    			Movie movieExists = dao.findById(id);
    			
    			if (movieExists != null) {
    				System.out.println("Enter new movie name: ");
    				String movieName = scanner.next();
    				
    				Movie movieNew = new Movie(movieExists.getId(), movieName);
    				
    				
    				dao.update(movieExists, movieNew);
    			} else {
    				System.out.println("Does not exists");
    			}
    		break;
    		case 4:
    			System.out.println("Enter Movie Id: ");
    			Integer idDelete = scanner.nextInt();
    			
    			Movie movieExistsDelete = dao.findById(idDelete);
    			
    			if (movieExistsDelete != null) {
    				dao.remove(movieExistsDelete);
    			} else {
    				System.out.println("Does not exists");
    			}
    		break;
    		default:
    			System.out.println("Invalid Option");
    	}

    }
}
