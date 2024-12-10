package com.hemebiotech.analytics;

import java.util.Map;
/**
 * The loaded symptoms data on writeSymptoms() will be written to a file.
 * 
 */
public interface ISymptomWriter {
	/**
	 * @param symptoms only accepts type Map<String, Integer>.
	 * If you have data in a List type, you must first convert it
	 * to a Map<String, Integer> before passing it to the method.
	 */
	public void writeSymptoms(Map<String, Integer>symptoms);
}