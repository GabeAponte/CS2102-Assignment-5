/**
 * this the the Examples class that
 * holds all the test cases for the program
 * 
 * @author Gabe Aponte
 */
import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class Examples {
	GregorianCalendar jan52017 = new GregorianCalendar(2017, 0, 5); 
	GregorianCalendar jan52018 = new GregorianCalendar(2018, 0, 5); 
	GregorianCalendar feb5 = new GregorianCalendar(2018, 1, 5); 
	GregorianCalendar may18 = new GregorianCalendar(2018, 4, 18); 
	GregorianCalendar aug3 = new GregorianCalendar(2018, 7, 3); 
	GregorianCalendar aug27 = new GregorianCalendar(2018, 7, 27); 
	GregorianCalendar nov1 = new GregorianCalendar(2018, 11, 1); 
	GregorianCalendar dec3 = new GregorianCalendar(2018, 9, 3); 
	GregorianCalendar dec8 = new GregorianCalendar(2018, 9, 8); 
	GregorianCalendar apr12 = new GregorianCalendar(2018, 3, 12); 
	GregorianCalendar mar12 = new GregorianCalendar(2018, 2, 12); 

	Time sixam = new Time(6,0);
	Time sixpm = new Time(6,0);
	Time noon = new Time(12,0);
	Time midnight = new Time(24,0);

	Reading r1 = new Reading(midnight, 1, 9.4);
	Reading r2 = new Reading(sixpm, 65, 3.3);
	Reading r3 = new Reading(sixam, 20, 3.5);
	Reading r4 = new Reading(sixam, 32, 1.8);
	Reading r5 = new Reading(sixpm, 51, 0.0);
	Reading r6 = new Reading(sixam, 54, 5.5);
	Reading r7 = new Reading(sixam, 67, 2.0);
	Reading r8 = new Reading(noon, 71, 1.0);
	Reading r9 = new Reading(noon, 80, .5);
	Reading negativeR = new Reading(midnight, -10, 12.2);
	Reading negativeR2 = new Reading(midnight, 10, -12.2);
	
	LinkedList<Reading> readings1 = new LinkedList<Reading>();
	LinkedList<Reading> readings2 = new LinkedList<Reading>();
	LinkedList<Reading> readings3 = new LinkedList<Reading>();
	LinkedList<Reading> readings4 = new LinkedList<Reading>();
	LinkedList<Reading> readings5 = new LinkedList<Reading>();
	LinkedList<Reading> readings6 = new LinkedList<Reading>();
	LinkedList<Reading> readings7 = new LinkedList<Reading>();
	LinkedList<Reading> readings8 = new LinkedList<Reading>();
	LinkedList<Reading> readings9 = new LinkedList<Reading>(); //empty list of readings 
	LinkedList<Reading> readings10 = new LinkedList<Reading>();
	
	ReportList reportList = new ReportList();

	public Examples(){
		readings1.add(r2);
		readings1.add(r7);
		
		readings2.add(r8);
		readings2.add(r9);
		
		readings3.add(r2);
		
		readings4.add(r1);
		readings4.add(r3);
		
		readings5.add(negativeR);
		readings5.add(r4);
		
		readings6.add(r5);
		readings6.add(r6);
		
		readings7.add(negativeR);
		readings8.add(r5);
		
		readings10.add(negativeR2);
		
		DailyWeatherReport dReport1 = new DailyWeatherReport(jan52017, readings4);
		DailyWeatherReport dReport12 = new DailyWeatherReport(jan52018,readings5);
		DailyWeatherReport dReport2 = new DailyWeatherReport(feb5,readings7);
		DailyWeatherReport dReport3 = new DailyWeatherReport(may18,readings3);
		DailyWeatherReport dReport4 = new DailyWeatherReport(aug3,readings1);
		DailyWeatherReport dReport5 = new DailyWeatherReport(aug27,readings2);
		DailyWeatherReport dReport6 = new DailyWeatherReport(dec3,readings6);
		DailyWeatherReport dReport7 = new DailyWeatherReport(dec8,readings7);
		DailyWeatherReport dReport8 = new DailyWeatherReport(nov1,readings8);
		DailyWeatherReport dReport9 = new DailyWeatherReport(apr12,readings9);
		DailyWeatherReport dReport10 = new DailyWeatherReport(mar12,readings10);

		reportList.addReport(dReport1);
		reportList.addReport(dReport12);
		reportList.addReport(dReport2);
		reportList.addReport(dReport3);
		reportList.addReport(dReport4);
		reportList.addReport(dReport5);
		reportList.addReport(dReport6);
		reportList.addReport(dReport7);
		reportList.addReport(dReport8);
		reportList.addReport(dReport9);
		reportList.addReport(dReport10);
	}

	//tests the averageTempForMonth method on a month with multiple temperature readings 
	@Test
	public void testAverageTempForMonth() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageTempForMonth(7, 2018), 70.75, .01); 
	}

	//tests the averageTempForMonth method on a month that has only one temperature reading
	@Test
	public void testAverageTempForMonth2() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageTempForMonth(4, 2018), 65, .01); 
	}

	//tests the averageTempForMonth method when there are two different years with the same month
	@Test
	public void testAverageTempForMonth3() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageTempForMonth(0, 2017), 10.5, .01); 
	}
	
	//tests averageTempForMonth method when the average temperature is negative 
	@Test
	public void testAverageTempForMonth4() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageTempForMonth(1, 2018), -10, .01); 
	}
	
	//tests averageTempForMonth method on a month with no readings (empty list of readings)
	@Test
	public void testAverageTempForMonth5() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.averageTempForMonth(3, 2018), 0, .01); 
	}

	//tests the totalRainfallForMonth method on a month with multiple rainfall readings 
	@Test
	public void testTotalRainfallForMonth() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.totalRainfallForMonth(7, 2018), 6.8, .01); 
	}

	//tests the totalRainfallForMonth method on a month that has only one rainfall reading
	@Test
	public void testTotalRainfallForMonth2() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.totalRainfallForMonth(4, 2018), 3.3, .01); 
	}

	//tests the totalRainfallForMonth method when there are two different years with the same month
	@Test
	public void testTotalRainfallForMonth3() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.totalRainfallForMonth(0, 2017), 12.9, .01); 
	}
	
	//tests the totalRainfallForMonth method when there is no rainfall in a month
	@Test
	public void testTotalRainfallForMonth4() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.totalRainfallForMonth(10, 2018), 0.0, .01); 
	}
	
	//tests totalRainfallForMonth method on a month with no readings (empty list of readings)
	@Test
	public void testTotalRainfallForMonth5() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.totalRainfallForMonth(3, 2018), 0.0, .01); 
	}
	
	//tests totalRainfallForMonth method on a month where the total rainfall readings were negative (error in readings)
	@Test
	public void testTotalRainfallForMonth6() {
		WeatherMonitor monitor = new WeatherMonitor(reportList);
		assertEquals(monitor.totalRainfallForMonth(2, 2018), 0.0, .01); 
	}
}
