package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The constructor "ReadSymptomsDataFromFile" sets the file path of the data to be read.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private List<String>symptomsList = new ArrayList<String>();
	
	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * GetSymptoms method implements the ISymptomReader interface.
	 * This method reads a file using the BufferedReader and FileReader classes.
	 * It stores all symptoms in an ArrayList, with each symptom saved in a separate index of the list.
	 * @exception FileNotFoundException Thrown if the specified file cannot be found by FileReader.
	 * @exception IOException Thrown if an error occurs while reading the file.
	 * @return List<String> containing all symptoms read from the file.
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> symptoms = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					symptoms.add(line);
					line = reader.readLine();
				}
				reader.close();		
				
			} catch (FileNotFoundException e) {
				System.out.println("File not found: " + e.getMessage());
				
			} catch (IOException e) {
				System.out.println("An error occurred while reading the file: " + e.getMessage() );
				e.printStackTrace();
			}
		}
		return symptoms;
	}
	
	/**
	 * This method is created to display all symptoms found in the file by reading them using the GetSymptoms method.
	 * It prints each symptom and the total number of symptoms in the list.
	 */
	@Override
	public void showSymptoms() {
		symptomsList = getSymptoms();
		symptomsList.forEach(System.out::println);
		System.out.println(symptomsList.size());
	}

}
