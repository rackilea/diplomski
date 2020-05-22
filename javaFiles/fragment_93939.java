try {
    Date toDate = new Date();
    String newDateString = "2013-05-31";

    System.out.println("From " + toDate);
    System.out.println("To " + newDateString);

    Date endDate = new SimpleDateFormat(OLD_FORMAT).parse(newDateString);

    System.out.println("endDate " + endDate);

    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(toDate);
    System.out.println(toDate);

    SimpleDateFormat newFormat = new SimpleDateFormat(NEW_FORMAT);

    while (cal2.getTime().before(endDate)) {
        cal2.add(Calendar.DATE, 1);
        Date date = (cal2.getTime());
        System.out.println(date + "/" + newFormat.format(date));
    }
} catch (Exception exp) {
    exp.printStackTrace();
}