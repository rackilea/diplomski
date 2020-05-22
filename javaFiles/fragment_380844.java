private String convertDate(String mydate) {

        String date = mydate;
        String firstLetter = date.substring(0,4).toUpperCase();
        String restLetters = date.substring(4).toLowerCase();
        date = firstLetter+restLetters;

        DateTimeFormatter oldFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy", new Locale("en"));
    LocalDate parsedDate = LocalDate.parse(date, oldFormat);

    DateTimeFormatter newFormat = DateTimeFormatter.ISO_DATE;
    String newDate = parsedDate.format(newFormat);
   return newDate;
  }