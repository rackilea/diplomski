public String parseDate(StringBuilder dateString, String formatString) {
        String separator = "";
        String slashSeperator = "/";
        if (formatString.contains(slashSeperator)) {
            separator = slashSeperator;
        } else {
            String dotSeparator = ".";
            if (formatString.contains(dotSeparator)) {
                separator = dotSeparator;
            }
        } 

    if (dateString.length() == 8) {
        dateString.insert(2, separator);
        dateString.insert(5, separator);
    } else {
        return "False Date Entered";
    }

    return dateString.toString();
}