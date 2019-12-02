package testes;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(new Date().getTime());
	}
	
	public static Timestamp addSecondsToCurrentTimestamp(Integer seconds) {		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, seconds);
		return new Timestamp(cal.getTime().getTime());		
	}
	
	public static Timestamp addMinutesToCurrentTimestamp(Integer minutes) {		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, minutes);
		return new Timestamp(cal.getTime().getTime());		
	}
	
	public static Timestamp addHoursToCurrentTimestamp(Integer hours) {		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, hours);
		return new Timestamp(cal.getTime().getTime());		
	}
	
	public static boolean isInRange(Integer initialTime, Integer finalTime) {
		Calendar cal = Calendar.getInstance();
		if(cal.get(Calendar.HOUR_OF_DAY) >= initialTime  && cal.get(Calendar.HOUR_OF_DAY) < finalTime ) {
			return true;
		}else {
			return false;
		}
	}
}