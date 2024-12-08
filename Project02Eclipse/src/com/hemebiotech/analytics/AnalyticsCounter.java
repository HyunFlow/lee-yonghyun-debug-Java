package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		
		/* Read the file "symptoms.txt"
		 * Create a symptoms List as ArrayList
		 * Count the occurrences of "headache", "rash", "pupils" on the list. */
		reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String>symptoms = new ArrayList<>();
		symptoms = reader.GetSymptoms();
		
		Map<String, Integer>symptomsData = countSymptoms(symptoms);
		
		/* Write a Text file provided by symptomsData. */
		writer = new WriteSymptomDataToFile();
		writer.writeSymptoms(symptomsData);
	}
	
	/* Function count the occurrence of symptoms */
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
		
		Map<String, Integer>symptomsData = new TreeMap<>();
		symptomsData.put("headache", headacheCount);
		symptomsData.put("rash", rashCount);
		symptomsData.put("dialated pupils", pupilCount);
		
		return symptomsData;
	}
	
	/* Function sort the  words into alphabetical order */
	public Map<String, Integer> sortSymptoms(Map<String, Integer>symptomsData) {
		symptomsData = new TreeMap<String, Integer>();		
		return symptomsData;
	}
}
