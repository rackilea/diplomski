String dateString = "Fr, 1. Jan";
    DateFormat format = new SimpleDateFormat("EE, d. MMM");
    Date date = null;
    try {
        date = format.parse(dateString);
    } catch (Exception e) {
        e.printStackTrace();
    }
    date.setYear(new Date().getYear()); //alternativ: date.setYear(2016);

    System.out.println(date);
    System.out.println(format.format(date));