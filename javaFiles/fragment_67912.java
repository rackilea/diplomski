import com.google.common.base.Splitter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Converts the string provided to a Date object
 * @param input String output of toString() from a GregorianCalendar object
 * @return Date object
 * @throws ParseException When the values received are invalid
 */
public Date convertGregorianCalendarStringOutputToDate(final String input) throws ParseException {

    // Parses the string received with a format of tuples key=value, separated by commas
    String formatted = input.replaceAll("\\]|\\/|\"","");
    formatted = formatted.replaceFirst("\\[", "");
    formatted = formatted.replaceAll("\\[", ",");

    // Creates a map of the key-values parsed
    Map<String, String> params = Splitter
                .on(",")
                .withKeyValueSeparator("=")
                .split(formatted);

    StringBuffer stringDate = new StringBuffer(params.get("YEAR"));
    stringDate.append("-")
            .append(params.get("MONTH"))
            .append("-")
            .append(params.get("DAY_OF_MONTH"))
            .append(" ")
            .append(params.get("HOUR_OF_DAY"))
            .append(":")
            .append(params.get("MINUTE"))
            .append(":")
            .append(params.get("SECOND"));

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
    return(sdf.parse(stringDate.toString()));
}