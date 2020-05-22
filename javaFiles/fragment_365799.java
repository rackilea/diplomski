String text = "Welcome, your drive today to the LAX will be (45+ min) and the tolls will cost ($2.50). Enjoy your drive!";

tripMiles = getNumberFromString("(?i)(\\d+)\\s+ min", text);

public static double getNumberFromString(String value, final String s)
{
    double n = 0.0;
    Matcher M = Pattern.compile(value).matcher(s);

    while (((Matcher)M).find())
    {
        try {
            n = Double.parseDouble(((Matcher)M).group(1));
            if (debug) Log.v(TAG, "Number is : " + ((Matcher)M).group(1));
        }
        catch (Exception ex) {
            n = 0.0;
        }
    }

    return n;
}