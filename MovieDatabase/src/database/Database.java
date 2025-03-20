package database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

import movie.Movie;
import fileio.fileRead;
import fileio.fileWrite;

public class Database {
	// Fields
	private ArrayList<Movie> movies;
	private String filename;
	// Constructor
	public Database(String filename){
		this.filename = filename;
		movies = new ArrayList<>();
		fileRead fr = new fileRead(filename);

		for(int i = 0; i < fr.getNumberOfLines(); i++){
			Movie tempMovie = new Movie("", "", "", "", 0, 0);

			String raw = fr.getLine(i);
			StringTokenizer tokenizer = new StringTokenizer(raw, "\\");

			tempMovie.setTitle(tokenizer.nextToken());
			tempMovie.setYear(Integer.parseInt(tokenizer.nextToken()));
			tempMovie.setActor1(tokenizer.nextToken());
			tempMovie.setActor2(tokenizer.nextToken());
			tempMovie.setDirector(tokenizer.nextToken());
			tempMovie.setRuntimeMinutes(Integer.parseInt(tokenizer.nextToken()));

			movies.add(tempMovie);
		}
	}
	// TOOD: Just print the movies informaiton if is found no need to return any values to the called method
	// Methods
	public void addEntry(Movie newEntry){
		movies.add(newEntry);
		
		String tokenized = "\n" + newEntry.getTitle() + "\\" + newEntry.getYear() + "\\" + newEntry.getActor1() + "\\" + newEntry.getActor2() + "\\" + newEntry.getDirector() + "\\" + newEntry.getRuntime();

		fileWrite writer = new fileWrite(filename);

		writer.writeLine(tokenized);
		writer.saveFile();
	}
	
	public void searchByTitle(String title) {
		boolean found = false;

		for(int i=0; i<movies.size(); ++i) {
			if(Objects.equals(title, movies.get(i).getTitle().toLowerCase())) {
				Movie movie = movies.get(i);
				displayTitleMovie(movie);
				found = true;
			}
		}

		displayError(found, "title");
	}
	
	public void searchByActor(String actor){
		boolean	found = false;

		for(int i=0; i<movies.size(); ++i) {
			if((Objects.equals(actor, movies.get(i).getActor1().toLowerCase()) || Objects.equals(actor, movies.get(i).getActor2().toLowerCase()))) {
				Movie movie = movies.get(i);
				displayMovie(movie);

				found = true;
			}
		}

		displayError(found, "actor");
	}
	
	public void searchByDirector(String director){
		boolean found = false;

		for(int i=0; i<movies.size(); ++i) {
			if(Objects.equals(director, movies.get(i).getDirector().toLowerCase())) {
				Movie movie = movies.get(i);
				displayMovie(movie);

				found = true;
			}
		}

		displayError(found, "director");
	}
	
	public void searchByYear(int year){
		boolean found = false;

		for(int i=0; i<movies.size(); ++i) {
			if((year == movies.get(i).getYear())) {
				Movie movie = movies.get(i);
				displayMovie(movie);

				found = true;
			}
		}

		displayError(found, "year");
	}
	
	public void searchByRuntime(int runtime){
		boolean found = false;

		for(int i=0; i<movies.size(); ++i) {
			if((runtime == movies.get(i).getRuntime())) {
				Movie movie = movies.get(i);
				displayMovie(movie);

				found = true;
			}
		}

		displayError(found, "runtime");
	}

	public static void displayTitleMovie(Movie movie) {
		System.out.println("Actors: " + movie.getActor1() + ", " + movie.getActor2());
		System.out.println("Director: " + movie.getDirector());
		System.out.println("Year: " + movie.getYear());
		System.out.println("Runtime: " + movie.getRuntime() + " minutes");
	}

	public static void displayMovie(Movie movie) {
		System.out.println("Title: " + movie.getTitle());
		System.out.println("Actors: " + movie.getActor1() + ", " + movie.getActor2());
		System.out.println("Director: " + movie.getDirector());
		System.out.println("Year: " + movie.getYear());
		System.out.println("Runtime: " + movie.getRuntime() + " minutes");
	}

	public static void displayError(boolean found, String type) {
		if(!found) {
			System.out.println("No movie with that " + type + " was found");
		}
	}
}
