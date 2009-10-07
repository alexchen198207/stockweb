package chart.study.indicator.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {

	public static int differDays(String date1, String date2) {
		long tDifMili = 0;
		try {
			SimpleDateFormat tFormat = new SimpleDateFormat("yyyyMMdd");
			int tDiferenca = 0;

			Date tDataIni = tFormat.parse(date1);
			Date tDataFim = tFormat.parse(date2);

			tDifMili = tDataFim.getTime() - tDataIni.getTime();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return (int) (tDifMili / (1000 * 60 * 60 * 24));
	}

}
