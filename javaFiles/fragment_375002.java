public String truncate(String dateString){
  int numberOfDigits = dateString.substring(dateString.indexOf("."), dateString.length() - 1).length();

  String justMilliSecondsDate = null;
  if (numberOfDigits == 3) {
    justMicrosDate = dateString;
    } 
  else if (numberOfDigits > 3) {
    justMilliSecondsDate = dateString.substring(0, dateString.length() - numberOfDigits + 3);
  } 
  else {
      justMilliSecondsDate = dateString;
      for (int i = numberOfDigits ; i < 3 ; i++) justMilliSecondsDate += "0";
  }

  return justMilliSecondsDate;
}