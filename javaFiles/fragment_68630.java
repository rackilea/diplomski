String durationString = "PTHMS";
    // if no digits, insert 0 before last letter
    if (! durationString.matches(".*\\d.*")) {
        durationString = durationString.replaceFirst("(?=[HMS]$)", "0");
    }
    // then delete letters that do not have a digit before them
    durationString = durationString.replaceAll("(?<!\\d)[HMS]", "");