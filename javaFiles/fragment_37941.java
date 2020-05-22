String oldString = "2009-12 Dec";
Calendar calendar = Calendar.getInstance();
calendar.setTime(new SimpleDateFormat("yyyy-MM").parse(oldString)); // Yes, month name is ignored but we don't need this.
calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
String newString = new SimpleDateFormat("dd-MMM-yyyy").format(calendar.getTime()).toUpperCase();
System.out.println(newString); // 31-DEC-2009