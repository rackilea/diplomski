Calendar someCalendar1 = Calendar.getInstance(); // current date/time
someCalendar1.add(Calendar.DATE, -14);

if (someDate.compareTo(someCalendar1.getTime()) < 0) {
   ...Code...                           
}