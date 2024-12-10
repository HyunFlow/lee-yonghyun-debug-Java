package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class serves as the entry point of the application.
 * 
 * 1. Reads a file named "symptoms.txt" and loads its content into a list.
 * 2. Creates an instance of the AnalyticsCounter class.
 * 3. Counts occurrences of each symptom and converts the data from a list to a Map.
 * 4. Sorts the symptom data using the sortSymptoms() method.
 * 5. Writes the sorted result to a file named "result.out".
 */
public class Main {

	public static void main(String[] args) {
		
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile();
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
		
		List<String>symptoms = new ArrayList<>();
		symptoms = reader.GetSymptoms();
		
		Map<String, Integer>symptomsData = analyticsCounter.countSymptoms(symptoms);
		analyticsCounter.sortSymptoms(symptomsData);
	
		writer.writeSymptoms(symptomsData);
	}

}
