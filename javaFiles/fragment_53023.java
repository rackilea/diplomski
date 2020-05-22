public int compare(String date1, String date2) {
  int year = date1.substring(6).compareTo(date2.substring(6));
  if (year == 0) {
     int month = date1.substring(3,5).compareTo(date2.substring(3,5));
     if (month == 0) {
       return date1.substring(0,2).compareTo(date2.substring(0,2));
     } else {
       return month;
     }
  } else {
     return year;
  }
}