/* READ THIS!: The idea behind this class is that we save the "writeBuffer" in memory but do not actually write the file to disk until someone calls the 
 * "saveFile" method. The reason for this is for performance and to prevent keeping an open file pointer (which is poor form and risky) */

package fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class fileWrite {
	// Fields
	private ArrayList<String> writeBuffer;
	private String filename;
	
	// Constructor
	public fileWrite(String filename){
		this.filename = filename; // Save filename for later
		writeBuffer = new ArrayList<>();
	}
	
	//Methods
	public void writeLine(String newLine){
		writeBuffer.add(newLine);
	}

	public void saveFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
			for (String line : writeBuffer) {
				line = line.trim();

				writer.write(line + System.lineSeparator());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		writeBuffer.clear();
	}
}
