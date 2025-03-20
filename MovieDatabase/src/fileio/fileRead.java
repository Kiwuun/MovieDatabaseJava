package fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileRead {
	// Fields
	private ArrayList<String> lines;
	
	// Constructor
	public fileRead(String filename){
		lines = new ArrayList<>();
		//TODO: Open the filename, read in the data into the lines arraylist, and close the file when done...
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;

			while((line = reader.readLine()) != null) {
				lines.add(line);
			}

		} catch (IOException e) {
			System.out.println("Filename doesn't exist");
		}
	}
	
	// Methods
	public int getNumberOfLines(){
		return lines.size();
	}
	
	public String getLine(int index){
		return lines.get(index);
	}
}
