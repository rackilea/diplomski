SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
Calendar wholeDate = new GregorianCalendar();

System.out.println(txtMmddyyyy.getText());
System.out.println(wholeDate.get(Calendar.MONTH) + " " + wholeDate.get(Calendar.DAY_OF_MONTH) + " " + wholeDate.get(Calendar.YEAR));

try {
    wholeDate.setTime(sdf.parse(txtMmddyyyy.getText()));
} catch (ParseException e3) {
    System.out.println("Failure");
    e3.printStackTrace();
}

System.out.println(wholeDate.get(Calendar.MONTH) + " " + wholeDate.get(Calendar.DAY_OF_MONTH) + " " + wholeDate.get(Calendar.YEAR));