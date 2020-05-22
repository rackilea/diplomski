/**
 * If valid this method will return a string indicating the Time Format 
 * otherwise it will return the uppercase word string: "NONE".<br>
 * 
 * @param time (String) The time to validate in HH:mm or hh:mm (am/pm).<br>
 * 
 * @return (String) Either "24 Hour Format", "12 Hour Format", or "NONE" if 
 * validation fails.
 */
public static String validateTime(String time) {
    String fmt = "NONE";
    // 12 Hour Time...
    if (time.matches("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)")) {
        fmt = "12 Hour Format";
    }        
    // 24 Hour Time...
    else if (time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
        fmt = "24 Hour Format";
    }
    return fmt;
}