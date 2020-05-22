private void updatePrimer(String dateString) {
    Calendar calTest = Calendar.getInstance();
    calTest.setTime(primer);
    int day = calTest.get(Calendar.DAY_OF_WEEK);
    try {
        primer = simpleFormat.parse(dateString);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println(day);
    shortString = shortFormat.format(primer);
    System.out.println(shortString);
    labelTrip = true;
    stringTrip = dateString;
    updateLabels(labelTrip, stringTrip);
}