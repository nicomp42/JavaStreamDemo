/*
 * Bill Nicholson 
 * nicholdw@ucmail.uc.edu
 */
package javaStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import vehicle.Vehicle;

/***
 * Stream Demonstration
 * @author nicomp
 *
 */
public class StreamDemo {

	public static void main(String[] args) {
		demonstrate();
	}
	public static void demonstrate() {
		System.out.println(MethodHandles.lookup().lookupClass() + "...");
		List<String> states = Arrays.asList("Ohio", "Indiana", "Michigan", "Illinois", "Montana","Idaho", "Alaska",
				                             "Florida", "South Carolina", "North Carolina", "Washington", "California", "Oregon",
				                             "Vermont", "Maine", "Rhode Island", "Georgia", "Kentucky");
		
		// Get list of states starting with O
		List<String> os = states.stream().filter(string -> string.startsWith("O")).collect(Collectors.toList());	
		System.out.println(os.toString());
		
		// Demonstrate a mapping transformation
		Set<String> mySet = states.stream().map(s -> s + " " + s).collect(Collectors.toSet());
		System.out.println(mySet);
		
		// Some Vehicle objects
		List<Vehicle> vehicles = Arrays.asList(new Vehicle("Chevrolet",  "Corvette", 200),
				                               new Vehicle("Chevrolet",  "Camaro",    150),
				                               new Vehicle("Chevrolet",  "Chevette",   70),
				                               new Vehicle("Buick",      "Regal",     100),
				                               new Vehicle("Chevrolet",  "Corvair",   120),
				                               new Vehicle("Ford",       "Festiva",    90),
				                               new Vehicle("Ford",       "Explorer",  100),
				                               new Vehicle("Pontiac",    "T-1000",     70)
				                              );
		
		// Print all vehicles with top speed >= 100
		vehicles.stream()  
        .filter(vehicle -> vehicle.getTopSpeed() >= 100)  
        .forEach(vehicle -> System.out.println(vehicle.toString()));
		
		demoWords();
		
		HTMLUnitDemo();
		
	}
	/**
	 * Demonstrate how to process words with streams
	 * Herein we have an ArrayList of Strings that can do fun stuff with
	 */
	public static void demoWords() {
		List<String> words = readDemoWordFileUsingCoolStuff("Data\\jumbled english FILTERED.ALL.txt");
		System.out.println("demoWords(): " + words.size() + " words read.");
		long longWords= words.stream().filter(word -> word.length() > 10).count();
		System.out.println("demoWords(): " + longWords + " words are over 10 characters");
		
		long wordsWithsecondLetter = words.stream().filter(word -> word.substring(1,2).equals("e")).count();
		System.out.println("demoWords(): " + wordsWithsecondLetter + " words have e as the second letter");
		
		ArrayList<String> wordsWithSecondLetterE = (ArrayList<String>) words.stream().filter(word -> word.substring(1,2).equals("e")).collect(Collectors.toList());
		Collections.sort(wordsWithSecondLetterE);
		System.out.println("The first word with e as the second letter = " + wordsWithSecondLetterE.get(0));
		
		System.out.println("All the words containing 'fishy' are " );
		words.stream().filter(word -> word.contains("fishy")).forEach(word -> System.out.println(word));
		
		
	}
	/**
	 * Read the word list from a text file
	 * @param wordsFile the file of words to be processed
	 * @return The list of words
	 */
	public static ArrayList<String> readDemoWordFile(String wordsFile) {
		ArrayList<String> words = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(wordsFile);
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				words.add(word);
			}
		} catch (Exception ex) {
			System.err.print("readDemoWordFile(): " + ex.getLocalizedMessage());
		}
		return words;
	}
	/**
	 * Read the word list from a text file using the Files class
	 * @param wordsFile the file of words to be processed
	 * @return The list of words
	 */
	public static List<String> readDemoWordFileUsingCoolStuff(String wordsFile) {
		List<String> words = null;
		try {
			words = (ArrayList<String>) Files.lines(Paths.get(wordsFile)).collect(Collectors.toList());
		} catch (Exception ex) {
			System.err.print("readDemoWordFileUsingCoolStuff(): " + ex.getLocalizedMessage());
		}
		return words;
	}
	/**
	 * Use the HTMLUnit project to scrape a web page
	 * This works but it spits out a lotta CSS parsing errors unless you turn off logging
	 * https://www.baeldung.com/htmlunit
	 */
	public static void HTMLUnitDemo() {
		// Supress all the warnings
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
		
		try (final WebClient webClient = new WebClient()) {
	        final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
	        System.out.println(page.getTitleText());
	        final String pageAsXml = page.asXml();
	        //Assert.assertTrue(pageAsXml.contains("<body class=\"composite\">"));

	        final String pageAsText = page.asText();
	        //Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
	    } catch (Exception ex) {
	    	System.err.println( MethodHandles.lookup().lookupClass());
	    }
	}
}
