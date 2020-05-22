import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeZoneFormatter {
    private static final DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
    private static final TimeZone GMT_TIME_ZONE = TimeZone.getTimeZone("GMT+00:00");
    private static final Pattern GMT_PATTERN = Pattern.compile("(?:GMT)?([+-])?([012]?\\d)(:([0-5]?\\d))?");
    private static final Pattern REMOVE_LEADING_ZEROS = Pattern.compile("^0+(?!$)");
    private static final Set<String> VALID_IDS = new LinkedHashSet<String>(Arrays.asList(TimeZone.getAvailableIDs()));
    private static final boolean DEBUG = true;

    private DateFormat dateFormat;
    private TimeZone timeZone;

    public TimeZoneFormatter() {
        this(DEFAULT_DATE_FORMAT);
    }

    public TimeZoneFormatter(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
        this.timeZone = GMT_TIME_ZONE;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setTimezone(boolean positive, int hours, int minutes) {
        String timeZoneId = formatGmtId(positive, hours, minutes);
        setTimezone(timeZoneId);
    }

    public void setTimezone(String timeZoneId) {
        TimeZone newTimeZone = TimeZone.getTimeZone(timeZoneId);

        if (timeZone.getRawOffset() != 0 && newTimeZone.getRawOffset() == 0) {
            System.out.println("[ERROR] Invalid GMT TimeZone ID!");
        } else {
            timeZone = newTimeZone;
            dateFormat.setTimeZone(timeZone);
        }
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public String getTimezoneId() {
        return timeZone.getID();
    }

    // -------------------------------------------------------------------------
    // Begin internal parsing and formatting methods.
    // -------------------------------------------------------------------------

    private String parseGmtTimeZoneId(String id) {
        Matcher m = GMT_PATTERN.matcher(id);

        if (m.find()) {
            char sign = m.group(1) != null ? m.group(1).charAt(0) : '+';
            int hours = removeLeadingZeros(m.group(2));
            int minutes = 0;

            if (m.group(3) != null) {
                minutes = removeLeadingZeros(m.group(4));
            }

            return formatGmtId(sign, hours, minutes);
        }

        if (!VALID_IDS.contains(id)) {
            System.out.println("[ERROR] Could not parse GMT ID!");
        }

        return id;
    }

    private void setGmtTimezone(String gmtOffset) {
        String timeZoneId = parseGmtTimeZoneId(gmtOffset);
        setTimezone(timeZoneId);
    }

    private String formatGmtId(boolean positive, int hours, int minutes) {
        return formatGmtId(positive ? '+' : '-', hours, minutes);
    }

    private String formatGmtId(char sign, int hours, int minutes) {
        return String.format("GMT%c%02d:%02d", sign, hours, minutes);
    }

    private int removeLeadingZeros(String intStr) {
        return Integer.parseInt(intStr.replaceAll(REMOVE_LEADING_ZEROS.pattern(), ""));
    }

    private String formatDate(final Date time) {
        return String.format("%s (%s)", dateFormat.format(time),
                timeZone.getDisplayName());
    }

    // -------------------------------------------------------------------------
    // Begin main method and other static utility methods.
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        if (DEBUG) {
            printAllAvailableTimeZones();
        }

        final Date time = new Date();
        TimeZoneFormatter frmt = new TimeZoneFormatter();
        Scanner scan = new Scanner(System.in);

        try {
            System.out.printf("Current time: ");
            printDate(time, frmt);

            while (true) {
                System.out.print("Enter a timezone: ");
                frmt.setGmtTimezone(scan.nextLine());
                printDate(time, frmt);

                System.out.print("Continue? (y/n): ");
                String response = scan.nextLine().trim();
                if ((response.length() < 1 ? 'y' : response.charAt(0)) == 'n') {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }

        System.out.println("Done...");
    }

    public static void printDate(final Date date, TimeZoneFormatter formatter) {
        if (date == null) {
            throw new IllegalArgumentException("Please enter a non-null date.");
        }

        if (formatter == null) {
            formatter = new TimeZoneFormatter();
        }

        System.out.println(formatter.formatDate(date));
    }   

    public static void printAllAvailableTimeZones() {
        System.out.println("Available Time Zones:");
        List<TimeZone> timeZones = new ArrayList<TimeZone>();

        for (String id : VALID_IDS) {
            timeZones.add(TimeZone.getTimeZone(id));
        }

        Collections.sort(timeZones, new Comparator<TimeZone>() {
            @Override
            public int compare(TimeZone t1, TimeZone t2) {
                int offsetDiff = t1.getRawOffset() - t2.getRawOffset();

                if (offsetDiff == 0) {
                    int nameDiff = t1.getDisplayName().compareTo(t2.getDisplayName());

                    if (nameDiff == 0) {
                        return t1.getID().compareTo(t2.getID());
                    } else {
                        return nameDiff;
                    }
                } else {
                    return offsetDiff;
                }
            }
        });

        for (TimeZone timeZone : timeZones) {
            System.out.printf("%s : %32s : %s%n", getFormattedOffset(timeZone),
                    timeZone.getID(), timeZone.getDisplayName());
        }

        System.out.println();
    }

    private static String getFormattedOffset(TimeZone timeZone) {
        int offset = timeZone.getRawOffset();
        char sign = offset < 0 ? '-' : '+';

        if (offset < 0) {
            offset *= -1;
        }

        int hours = offset / 3600000;
        int mins = (offset % 3600000) / 60000;

        return String.format("%c%02d:%02d", sign, hours, mins);
    }
}