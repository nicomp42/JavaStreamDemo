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
	public enum Condition {NEW, USED, WRECKED, REPAIRED, RESTORED};
	private Condition condition;
	public Vehicle(Condition condition, String make, String model, int topSpeed) {
		this.setMake(make);
		this.setModel(model);
		this.setTopSpeed(topSpeed);
	}
	public void setCondition(Vehicle.Condition condition) throws Exception {
		if (condition == Vehicle.Condition.NEW) {
			throw new Exception ("Can't change a vehicle condition to new");
		} else {
			this.condition = condition;
		}
	}
	public int getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String toString() {
		return make + " " + model + " " + topSpeed + " mph";
	}
}
