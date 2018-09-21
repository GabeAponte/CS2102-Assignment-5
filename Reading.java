/**
 * A class that holds the properties 
 * and methods for the Reading object
 * 
 * @author Gabe Aponte
 */
class Reading {
	private Time t;
	private int tempF;
	private double lastRainfall;

	Reading(Time t, int tempF, double lastRainfall){
		this.t = t;
		this.tempF = tempF;
		this.lastRainfall = lastRainfall;
	}
	
	/**
	 * This is the getTemp method which produces the
	 * the value of the tempF field
	 * 
	 * @return tempF  an integer representing the temperature 
	 */
	public int getTemp() {
		return this.tempF; 
	}

	/**
	 * This is the getRainfall method which produces the
	 * the value of the lastRainfall field
	 * 
	 * @return lastRainfall  an double representing the amount of rainfall 
	 */
	public double getRainfall() {
		return this.lastRainfall; 
	}
}
