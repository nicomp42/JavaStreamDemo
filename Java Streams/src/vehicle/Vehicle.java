/*
 * Bill Nicholson 
 * nicholdw@ucmail.uc.edu
 */
package vehicle;
/**
 * Models nothing in the real world, just a demo tool for stream work
 * @author nicomp
 *
 */
public class Vehicle {
	private int topSpeed;
	private String make;
	private String model;
	public enum Condition {NEW, USED, WRECKED, REPAIRED, RESTORED, SALVAGE};
	private Condition condition;
	public Vehicle(Condition condition, String make, String model, int topSpeed) {
		this.setMake(make);
		this.setModel(model);
		this.setTopSpeed(topSpeed);
		this.condition = condition;
	}
	/**
	 * Define the condition of the Vehicle
	 * @param condition The new condition
	 * @throws Exception If the new condition is NEW. We can't mnake a vehicle NEW again
	 */
	public void setCondition(Vehicle.Condition condition) throws Exception {
		if (condition == Vehicle.Condition.NEW) {
			throw new Exception ("Can't change a vehicle condition to new.");
		} else {
			this.condition = condition;
		}
	}
	/**
	 * Get top speed of the vehicle
	 * @return Top Speed of the vehicle
	 */
	public int getTopSpeed() {
		return topSpeed;
	}
	/**
	 * Set top speed of the vehicle
	 * @param topSpeed in mph
	 */
	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}
	/***
	 * Get make of the vehicle
	 * @return make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * Set the make of the vehicle
	 * @param make make of the vehicle
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * Get model of the vehicle
	 * @return model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * Set model of the vehicle
	 * @param model model of the vehicle
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * String representation of the object
	 * @return summary of the object
	 */
	public String toString() {
		return make + " " + model + " " + topSpeed + " mph, condition = " + condition.toString();
	}
}
