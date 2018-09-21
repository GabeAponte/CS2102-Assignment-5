/**
 * A class that holds the properties 
 * and methods for the DailyWeatherReport object
 * 
 * @author Gabe Aponte
 */
import java.util.GregorianCalendar;
import java.util.LinkedList;

class DailyWeatherReport {
	private GregorianCalendar date;
	private LinkedList<Integer> tempReadings;
	private LinkedList<Double> rainReadings;
	
	DailyWeatherReport(GregorianCalendar date, LinkedList<Reading> readings){
		this.date = date;
		tempReadings = new LinkedList<Integer>();
		rainReadings = new LinkedList<Double>();
		
		//for loop in the constructor that takes values from the readings list and 
		//pushes them into their respective list
		for (Reading r : readings) {
			tempReadings.push(r.getTemp());
			rainReadings.push(r.getRainfall());
		}
	}
	
	/**
	 * This is the getDate method which produces the
	 * the GregorianCalendar date field
	 * 
	 * @return date  a date based on the GregorianCalendar library
	 */
	public GregorianCalendar getDate() {
		return this.date;
	}
	
	/**
	 * This is the getTempList method which produces the
	 * the tempReadings list
	 * 
	 * @return tempReadings  a linkedlist of integers representing the temperature readings
	 */
	public LinkedList<Integer> getTempList() {
		return this.tempReadings;
	}
	
	/**
	 * This is the getRainList method which produces the
	 * the rainReadings list 
	 * 
	 * @return rainReadings  a linkedlist of doubles representing the rainfall readings
	 */
	public LinkedList<Double> getRainList() {
		return this.rainReadings;
	}
}
