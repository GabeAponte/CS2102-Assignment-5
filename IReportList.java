/**
 * This is the IReportList interface that holds the method headers that
 * will be shared to classes that implement it
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;

public interface IReportList {
	
	public boolean addReport(DailyWeatherReport report);
	public LinkedList<DailyWeatherReport> getMonthReports(int month, int year);
}
