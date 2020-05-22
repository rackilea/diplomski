public static Long parseTime(String value) {

    // ";" is a common typo - we are not punishing users for it
    value = value.trim().toLowerCase().replace(";", ":");

    RegExp time12 = RegExp.compile("^(1[012]|[1-9])([:.][0-5][0-9])?(\\s)?(a|p|am|pm)?$");
    RegExp time24 = RegExp.compile("^(([01]?[0-9]|2[0-3])[:.]?([0-5][0-9])?)$");

    if (time12.test(value) || time24.test(value)) {

        String hours = "0", minutes = "0";

        if (value.contains(":") || value.contains(".")) {
            String[] values = value.split("[:.]");
            hours =  values[0];
            minutes = values[1].substring(0, 2);
        } else {
            // Process strings like "8", "8p", "8pm", "2300"
            if (value.contains("a")) {
                hours = value.substring(0, value.indexOf("a")).trim();
            } else if (value.contains("p")) {
                hours = value.substring(0, value.indexOf("p")).trim();
            } else if (value.length() < 3) {
                hours = value;
            } else {
                hours =  value.substring(0, value.length() - 2);
                minutes = value.substring(value.length() - 2);
            }
        }
        if (value.contains("a") && hours.equals("12")) {
            // 12am is actually zero hours
            hours = "0";
        }

        Long time = (Long.valueOf(hours) * 60 + Long.valueOf(minutes)) * 60 * 1000;

        if (value.contains("p") && !hours.equals("12")) {
            // "pm" adds 12 hours to the total, except for 12pm
            time += 12 * 60 * 60 * 1000;
        }

        return time;
    }
    return null;
}