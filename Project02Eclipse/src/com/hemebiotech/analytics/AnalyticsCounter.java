package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The class has three main functions:
 * 1. Reads the symptoms data list.
 * 2. Counts the occurrences of each symptom in the data.
 * 3. Writes the count results to a file.
 
 * @param reader bring the file "symptoms.txt"
 * @param writer Make a file "result.out"
 
 */
public class AnalyticsCounter {

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		
		reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String>symptoms = new ArrayList<String>();
		symptoms = reader.getSymptoms();
		
		/** Convert symptoms list to Map */
		Map<String, Integer>symptomsData = countSymptoms(symptoms);
		
		/** Sort the counted symptoms in alphabetical order */
		sortSymptoms(symptomsData);
		
		/** Write the file "result.out" */
		writer = new WriteSymptomDataToFile();
		writer.writeSymptoms(symptomsData);
	}
	
	/** Function count the occurrence of symptoms */
	public Map<String, Integer> countSymptoms(List<String>symptoms){
		int headacheCount = 0;
		int rashCount = 0;
		int pupilCount = 0; 
		
		for(String symptom : symptoms) {
			if(symptom.equals("headache")) {
				headacheCount++;
			} else if(symptom.equals("rash")) {
				rashCount++;
			} else if(symptom.contains("pupils")) {
				pupilCount++;
			}
		}
		
		Map<String, Integer>symptomsData = new HashMap<>();
		symptomsData.put("headache", headacheCount);
		symptomsData.put("rash", rashCount);
		symptomsData.put("dialated pupils", pupilCount);
		
		return symptomsData;
	}
	
	/** Function Sort the words in alphabetical order */
	public Map<String, Integer> sortSymptoms(Map<String, Integer>symptomsData) {
		Map<String, Integer> sortedSymptomsData = new TreeMap<String, Integer>(symptomsData);		
		return sortedSymptomsData;
	}
}
