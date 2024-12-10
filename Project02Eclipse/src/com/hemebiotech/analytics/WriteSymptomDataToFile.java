package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * This class implements the ISymptomWriter interface and provides a method to write symptom data to a file.
 * It creates a file named 'result.out' and writes each symptom with its corresponding count to the file.
 * The data is written in the format: "symptom: count".
 * 
 * @see ISymptomWriter
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
/** The method creates a file named 'result.out' from the data provided in symptoms. */
	@Override
	public void writeSymptoms(Map<String, Integer>symptoms) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
			for(Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue());
				writer.newLine();
			} writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


