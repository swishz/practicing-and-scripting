package testes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author enrique
 *
 */
public class Person {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		DataUtils data =  null;
		int hours = 0;
		final String dateFormat = "yyyy_MM_dd";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		new SimpleDateFormat(dateFormat).format(new Date());

		System.out.println("formatted: " + sdf.format(cal.getTime()));
		System.out.println("original: " + cal);
		System.out.println("DateUtils: " + data.addHoursToCurrentTimestamp(hours));
	}
}