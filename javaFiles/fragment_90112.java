for (String dateString : dateStrings) {
     try {
          Date date = dateFormat.parse(dateString);
     } catch (ParseException ex) {
         // date can't be parsed, ignore & continue. 
     }
}