String dateString = "2012115";
      String formatString = "yyyyMMdd";
      if(dateString == null || dateString.length() != formatString.length()){
         throw new ParseException("Invalid Date Input", 0);
      }
      SimpleDateFormat formatter= new SimpleDateFormat(formatString);
      formatter.setLenient(false);
      Date date = df.parse(dateString);