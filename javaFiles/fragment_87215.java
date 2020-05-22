// The Regular Expression (RegEx) we are going to use...
String regEx = "(?i)(\\bSET\\b|\\bUNSET\\b)(.*?\\btime\\b.*?)?(\\d{2}\\:\\d{2}(\\s+)?(am|pm)?)";

String incomingString = "set time as 10:30 am";

String setType = "NONE AVAILABLE!"; // Default
String setTime = "NONE AVAILABLE!"; // Default
String timeFormat = "";             // Default

// Does the incoming String meet our requirements?
if (incomingString.trim().matches(regEx)) {
    // Yes it does...
    System.out.println("String contains valid content.");

    // Get the required information from the input String...
    Pattern r = Pattern.compile(regEx);
    Matcher m = r.matcher(incomingString);
    if (m.find()) {
        setType = m.group(1).toUpperCase();
        setTime = m.group(3).toUpperCase();
    }

    // Is the time Valid
    timeFormat = validateTime(setTime); // see validateTime() method
    if (timeFormat.equals("NONE")) {
        // Reset to defaults
        setType = "NONE AVAILABLE!";
        setTime = "NONE AVAILABLE!";
    }
}
// Display the findings...
System.out.println("Set Type: " + setType);
System.out.println("Time:     " + setTime + " (in " + timeFormat + ")");