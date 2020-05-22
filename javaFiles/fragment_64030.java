public String threeDaysBefore(){
    String threeDaysBefore = "";
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);

    cal.add(Calendar.DAY_OF_YEAR, -3);
    Date before = cal.getTime();
    SimpleDateFormat formatter = new SimpleDateFormat("dd");
    threeDaysBefore = formatter.format(before);
    return threeDaysBefore;
}