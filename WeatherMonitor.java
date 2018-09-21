/**
 * A class that holds the properties 
 * and methods for the WeatherMonitor object
 * 
 * @author Gabe Aponte
 */
import java.util.GregorianCalendar;
import java.util.LinkedList;

class WeatherMonitor {
	private IReportList reports;

	WeatherMonitor(IReportList reports){
		this.reports = reports;
	}

	/**
	 * This is the averageTempForMonth method which consumes a month and a year and produces
	 * the average temperature for that month of a specific year 
	 * 
	 * @param month  an int representing the month in GregorianCalendar form
	 * @param year  an int representing the year
	 * @return average  a local variable representing the average produced by the sum of temperatures divided by total temperature readings 
	 */
	public double averageTempForMonth(int month, int year) {
		double sumTemps = 0;
		int totalTemps = 0;
		
		for (DailyWeatherReport report: reports.getMonthReports(month, year)){
			for(Integer r : report.getTempList()) {
				sumTemps = r + sumTemps;
				totalTemps = totalTemps + 1;
			}
			if (totalTemps == 0)
				return 0; 
		}
		double average = (sumTemps/totalTemps);
		return average;
	}

	/**
	 * This is the totalRainfallForMonth method which consumes a month and a year and produces
	 * the total amount of rainfall for that month of a specific year 
	 * 
	 * @param month  an int representing the month in GregorianCalendar form
	 * @param year  an int representing the year
	 * @return total  a local variable representing the total rainfall amount
	 */
	public double totalRainfallForMonth(int month, int year) {
		double total = 0.0;

		for (DailyWeatherReport report: reports.getMonthReports(month, year)){
			for(double r : report.getRainList()) {
				total = r + total;
			}
			if (total < 0)
				total = 0.0;
		}
		return total; 
	}

	/**
	 * This is the addDailyReport method which consumes a GregorianCalendar date and a list of readings, 
	 * creates a new DailyWeatherReport and adds it to a list of reports 
	 * 
	 * @param date  a date in the GregorianCalendar form
	 * @param readings  a linkedlist of readings
	 */
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
		DailyWeatherReport aReport = new DailyWeatherReport(date, readings);
		reports.addReport(aReport);
	}
}
