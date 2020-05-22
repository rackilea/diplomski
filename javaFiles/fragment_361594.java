ArrayList<String> dateStringList = new ArrayList<String>();
    ArrayList<Date> dateList = new ArrayList<Date>();

    dateStringList.add("2015-11-09");
    dateStringList.add("2015-11-08");

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");

    for (String dateString : dateStringList) {
        try {
            dateList.add(simpleDateFormat.parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    for (Date date : dateList) {
        System.out.println("Date " + simpleDateFormat.format(date));
    }