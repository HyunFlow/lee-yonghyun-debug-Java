package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile symptomDataReader = new ReadSymptomDataFromFile("symptoms.txt");
		
		/* "showSymptoms" Fonction Test line. */
		symptomDataReader.showSymptoms();
		
		/* Create a symptoms list as an ArrayList and 
		count the occurrences of 'headache,' 'rash,' and 'pupils'. */
		List<String>symptoms = new ArrayList<>();
		symptoms = symptomDataReader.GetSymptoms();
		
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
		symptomsData.put("headache", headacheCount);
		symptomsData.put("rash", rashCount);
		symptomsData.put("dialated pupils", pupilCount);
		
		/* Write a Text file provided by symptomsData. */
		WriteSymptomDataToFile countedSymptomsWriter = new WriteSymptomDataToFile();
		countedSymptomsWriter.writeSymptoms(symptomsData);
	}
	
}
