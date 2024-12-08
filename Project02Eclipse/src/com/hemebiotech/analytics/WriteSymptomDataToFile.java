package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	@Override
	public void writeSymptoms(Map<String, Integer>symptoms) {
		
		System.out.println(symptoms);
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
			Set<Map.Entry<String, Integer>> entries = symptoms.entrySet();
			for(Map.Entry<String, Integer> entry : entries) {
				writer.write(entry.getKey() + ": " + entry.getValue());
				writer.newLine();
			} writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


