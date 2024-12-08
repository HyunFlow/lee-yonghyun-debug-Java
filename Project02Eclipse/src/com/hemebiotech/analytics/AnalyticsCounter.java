package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		
		/* Read the file "symptoms.txt"
		 * Create a symptoms List as ArrayList
		 * Count the occurrences of "headache", "rash", "pupils" on the list. */
		reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String>symptoms = new ArrayList<>();
		symptoms = reader.GetSymptoms();
		
		for(int i=0; i<symptoms.size(); i++) {
			String symptom = symptoms.get(i);
			if(symptom.equals("headache")) {
				headacheCount++;
			}
			else if(symptom.equals("rash")) {
				rashCount++;
			}
			else if (symptom.contains("pupils")) {
				pupilCount++;
			}
		}
		
		/* Count Symptoms Data Mapping to symptomsData */
		Map<String, Integer>symptomsData = new TreeMap<>();
		countSymptoms(symptoms);
		
		/* Write a Text file provided by symptomsData. */
		writer = new WriteSymptomDataToFile();
		writer.writeSymptoms(symptomsData);
	}
	
	/* Function count the occurrence of symptoms */
	public Map<String, Integer> countSymptoms(List<String>symptoms){
		Map<String, Integer>symptomsData = new TreeMap<>();
		symptomsData.put("headache", headacheCount);
		symptomsData.put("rash", rashCount);
		symptomsData.put("dialated pupils", pupilCount);
		return symptomsData;
	}
	
	/* Function sort the  words into alphabetical order */
	public Map<String, Integer> sortSymptoms(Map<String, Integer>symptoms) {
		symptoms = new TreeMap<String, Integer>();		
		return symptoms;
	}
}
