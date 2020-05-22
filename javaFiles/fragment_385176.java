public class LearnDate
{
    private static DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public static void main(final String[] arguments)
        throws ParseException
    {
        final String input1 = "14:21:15";
        final String input2 = "4 days 15:14:15";

        printDateInfo(input1);
        printDateInfo(input2);
    }

    private static String formatCalendar(final Calendar input)
    {
        return
            "" +
            input.get(Calendar.DAY_OF_MONTH) +
            monthName(input.get(Calendar.MONTH)) +
            input.get(Calendar.YEAR) +
            " " +
            timeFormat.format(input.getTime());
    }

    private static String monthName(final int month)
    {
        switch (month)
        {
            case Calendar.JANUARY:
                return "Jan";

            case Calendar.FEBRUARY:
                return "Feb";

            case Calendar.MARCH:
                return "Mar";

            case Calendar.APRIL:
                return "Apr";

            case Calendar.MAY:
                return "May";

            case Calendar.JUNE:
                return "Jun";

            case Calendar.JULY:
                return "Jul";

            default:
                return "blah";
        }
    }

    private static void printDateInfo(final String input)
        throws ParseException
    {
        String[] parsedInput = input.split(" ");
        Date time = null;

        if (parsedInput != null)
        {
            switch (parsedInput.length)
            {
                case 1:
                    time = timeFormat.parse(parsedInput[0]);
                    System.out.println("Just Time: " + timeFormat.format(time));
                    break;

                case 3:
                {
                    int duration;
                    Calendar end = Calendar.getInstance();
                    Calendar start = Calendar.getInstance();
                    Calendar timeValue = Calendar.getInstance();

                    time = timeFormat.parse(parsedInput[2]);
                    System.out.println("Time: " + timeFormat.format(time));
                    System.out.println("Duration: " + parsedInput[0] + " days.");

                    timeValue.setTime(time);
                    transferTime(start, timeValue);
                    transferTime(end, timeValue);

                    duration = Integer.parseInt(parsedInput[0]) - 1;
                    end.add(Calendar.DAY_OF_YEAR, duration);

                    System.out.println("Start: " + formatCalendar(start));
                    System.out.println("  End: " + formatCalendar(end));
                }
                    break;

                default:
                    System.out.println("Unrecognized format: " + input);
                    break;
            }
        }
    }

    private static void transferTime(
        final Calendar destination,
        final Calendar source)
    {
        destination.set(Calendar.HOUR_OF_DAY, source.get(Calendar.HOUR_OF_DAY));
        destination.set(Calendar.MINUTE, source.get(Calendar.MINUTE));
        destination.set(Calendar.SECOND, source.get(Calendar.SECOND));
    }
}