/**
 * A class that holds the properties 
 * and methods for the ReportList object
 * 
 * @author Gabe Aponte
 */
import java.util.GregorianCalendar;
import java.util.LinkedList;

class ReportList implements IReportList {
	private LinkedList<DailyWeatherReport> dailyReports;

	ReportList(){
		dailyReports = new LinkedList<DailyWeatherReport>();
	}
	
	ReportList(LinkedList<DailyWeatherReport> dailyReports){
		this.dailyReports = dailyReports;
	}

	/**
	 * This is the addReport method which consumes a DailyWeatherReport and 
	 * produces a boolean value indicating the report was added to dailyReports
	 * 
	 * @param report  a DailyWeatherReport object to be added
	 * @return true or false  a boolean value indicating if the report was added to dailyReports
	 */
	@Override
	public boolean addReport(DailyWeatherReport report) {
		return dailyReports.add(report);
	}
	
	/**
	 * This is the getMonthReports method which consumes a month and a year and produces 
	 * a list of reports from the inputed month and year
	 * 
	 * @param month  an int representing a month in GregorianCalendar form
	 * @param year  an int representing a year in GregorianCalendar form
	 * @return reportsForMonth  a local linkedlist of DailyWeatherReports that contains all the reports for that month and year
	 */
	@Override
	public LinkedList<DailyWeatherReport> getMonthReports(int month, int year){
		LinkedList<DailyWeatherReport> reportsForMonth = new LinkedList<DailyWeatherReport>();
		
		for(DailyWeatherReport report : this.dailyReports) {
			if((report.getDate().get(GregorianCalendar.MONTH) == month) && (report.getDate().get(GregorianCalendar.YEAR) == year)) {
				reportsForMonth.add(report);
			}
		}
		return reportsForMonth;
	}
}
