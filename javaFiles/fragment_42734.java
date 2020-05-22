Pattern datePatt = Pattern.compile("([A-Z]{2})-(\\d{4})-(\\d{2})");
    Matcher m = datePatt.matcher("MS-1990-10");
    if (m.matches()) {
        String g1 = m.group(1);
        String g2 = m.group(2);
        String g3 = m.group(3);
    }