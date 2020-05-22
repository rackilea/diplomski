DateTime dateTimeParser(String dateAsString)  
   {  
      DateTime res = dtf.parseDateTime(dateAsString);
      if (d.getYear() < 0) throw new IllegalArgumentException();  
      return res;  
   }