package vehicle;

public class Vehicle {
	private int topSpeed;
	private String make;
	private String model;
	public Vehicle(String make, String model, int topSpeed) {
		this.setMake(make);
		this.setModel(model);
		this.setTopSpeed(topSpeed);
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
