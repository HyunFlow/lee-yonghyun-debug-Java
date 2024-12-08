package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");
//		readSymptomDataFromFile.showSymptoms();
		
		List<String>symptoms = new ArrayList<>();
		symptoms = readSymptomDataFromFile.GetSymptoms();
		
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
		
		Map<String, Integer>symptomsData = new TreeMap<>();
		symptomsData.put("headache", headacheCount);
		symptomsData.put("rash", rashCount);
		symptomsData.put("dialated pupils", pupilCount);
		
		WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile();
		writeSymptomDataToFile.writeSymptoms(symptomsData);
	}
	
}
