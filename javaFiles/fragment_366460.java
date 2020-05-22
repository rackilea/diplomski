List<Date> dates = new ArrayList<>();

    try {
        dates.add(sdf.parse("10/03/2017"));
        dates.add(sdf.parse("9/03/2017"));
        dates.add(sdf.parse("8/03/2017"));
        dates.add(sdf.parse("7/03/2017"));
        dates.add(sdf.parse("6/03/2017"));
        dates.add(sdf.parse("23/02/2017"));
        dates.add(sdf.parse("3/02/2017"));
        dates.add(sdf.parse("2/02/2017"));
        dates.add(sdf.parse("1/02/2017"));
    } catch (ParseException e) {
        e.printStackTrace();
    }