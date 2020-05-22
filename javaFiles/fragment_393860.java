String input = "20160115";
    String format = "yyyyMMdd";
    try {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date date = df.parse(input);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.WEEK_OF_YEAR);

        System.out.println("Input " + input + " is in week " + week);
        return week;
    } catch (ParseException e) {
        System.out.println("Could not find a week in " + input);
        return 0;
    }