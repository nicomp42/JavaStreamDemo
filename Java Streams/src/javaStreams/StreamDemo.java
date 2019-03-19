package javaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		
		
		
	}
}
