public static String format_String(int hours, int minutes, int seconds)
{
    StringBuilder result = new StringBuilder(".");
    String sep = "", nextSep = " and ";
    if (seconds > 0) {
        result.insert(0, " seconds").insert(0, seconds);
        sep = nextSep;
        nextSep = ", ";
    }
    if (minutes > 0) {
        result.insert(0, sep).insert(0, " minutes").insert(0, minutes);
        sep = nextSep;
        nextSep = ", ";
    }
    if (hours > 0) {
        result.insert(0, sep).insert(0, " hours").insert(0, hours);
    }
    return result.toString();
}