package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
