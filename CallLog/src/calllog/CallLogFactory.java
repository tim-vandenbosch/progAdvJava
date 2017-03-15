package calllog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CallLogFactory implements ICallLogFactory {
	
	public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static final String DEFAULT_CALLLOG_ITEM_SEPARATOR = ";";

	public static String getDate(Date datum) {
		try {
			return DATEFORMAT.format(datum).split(" ")[0];
		} catch (Exception e) {
			System.err.println("Error formatting date "+e.getMessage());
			return "";
		}
	}
	
	public static String getTime(Date datum) {
		try {
			return DATEFORMAT.format(datum).split(" ")[1];
		} catch (Exception e) {
			System.err.println("Error formatting time "+e.getMessage());
			return "";
		}

	}

}
