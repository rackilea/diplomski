Pattern p = Pattern.compile("(\\d+)\\s+(.*?)s? ago");

Map<String, Integer> fields = new HashMap<String, Integer>() {{
    put("second", Calendar.SECOND);
    put("minute", Calendar.MINUTE);
    put("hour",   Calendar.HOUR);
    put("day",    Calendar.DATE);
    put("week",   Calendar.WEEK_OF_YEAR);
    put("month",  Calendar.MONTH);
    put("year",   Calendar.YEAR);
}};

String[] tests = {
        "3 days ago",
        "1 minute ago",
        "2 years ago"
};

for (String test : tests) {

    Matcher m = p.matcher(test);

    if (m.matches()) {
        int amount = Integer.parseInt(m.group(1));
        String unit = m.group(2);

        Calendar cal = Calendar.getInstance();
        cal.add(fields.get(unit), -amount);
        System.out.printf("%s: %tF, %<tT%n", test, cal);
    }
}