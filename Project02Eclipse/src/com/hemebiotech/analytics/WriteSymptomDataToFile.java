package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	/* The method creates a file named 'result.out' from the data provided in symptoms. */
	@Override
	public void writeSymptoms(Map<String, Integer>symptoms) {
		
		/* symptoms data check. Map<String, Integer> symptomsData come here. */
		System.out.println(symptoms); 
		
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


