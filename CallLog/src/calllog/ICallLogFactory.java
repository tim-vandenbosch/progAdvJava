package calllog;

import java.text.ParseException;

/**
 * Created by tim_v on 14/03/2017.
 */
public interface ICallLogFactory {
    /**
     * Create a CallLog object from a call log line (with ; as item separator)
     * @param callLogLine String
     * @return CallLog
     */
    static CallLog createCallLog(String callLogLine) {
        return createCallLog(callLogLine, CallLogFactory.DEFAULT_CALLLOG_ITEM_SEPARATOR);
    }

    /**
     * Create a CallLog object from a call log line
     * @param callLogLine String
     * @param itemSeparator String
     * @return CallLog
     */
    static CallLog createCallLog(String callLogLine, String itemSeparator) {

        String[] callLogArray = callLogLine.split(itemSeparator);

        CallLog callLog = new CallLog();
        callLog.setId(Integer.parseInt(callLogArray[0]));
        callLog.setNaam(callLogArray[1]);

        try {
            callLog.setDatum(CallLogFactory.DATEFORMAT.parse(callLogArray[2] + " " + callLogArray[3]));
        } catch (ParseException e) {
            System.err.println("Error parsing date for callog " + callLog.getId());
        }

        callLog.setBedrijf(callLogArray[4]);
        callLog.setOmschrijving(callLogArray[5]);
        callLog.setPrio(Integer.parseInt(callLogArray[6]));
        callLog.setStatus(CallLogStatus.getCallLogStatusType(callLogArray[7]));

        return callLog;

    }

    /**
     * Create a call log line from a CallLog object (with ; as iten separator)
     * @param callLog
     * @return
     */
    static String createCallLogLine(CallLog callLog) {
        return createCallLogLine(callLog, CallLogFactory.DEFAULT_CALLLOG_ITEM_SEPARATOR);
    }

    /**
     * Create a call log line from a CallLog object
     * @param callLog CallLog
     * @param itemSeparator String
     * @return String
     */
    static String createCallLogLine(CallLog callLog, String itemSeparator) {
        StringBuffer callLogBuffer = new StringBuffer();

        callLogBuffer.append(callLog.getId());					// 0
        callLogBuffer.append(itemSeparator);
        callLogBuffer.append(callLog.getNaam());				// 1
        callLogBuffer.append(itemSeparator);
        callLogBuffer.append(CallLogFactory.getDate(callLog.getDatum()));		// 2
        callLogBuffer.append(itemSeparator);
        callLogBuffer.append(CallLogFactory.getTime(callLog.getDatum()));		// 3
        callLogBuffer.append(itemSeparator);
        callLogBuffer.append(callLog.getBedrijf());				// 4
        callLogBuffer.append(itemSeparator);
        callLogBuffer.append(callLog.getOmschrijving());		// 5
        callLogBuffer.append(itemSeparator);
        callLogBuffer.append(callLog.getPrio());				// 6
        callLogBuffer.append(itemSeparator);
        callLogBuffer.append(callLog.getStatus().getValue());	// 7
        callLogBuffer.append(itemSeparator);

        return callLogBuffer.toString();

    }
}
