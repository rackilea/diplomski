public static String convertDate(String date)
   {

      SimpleDateFormat dateFormatQuery = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
      SimpleDateFormat dateFormatStored = new SimpleDateFormat("dd-MMM-yy");
      SimpleDateFormat dateFormatRet = new SimpleDateFormat("yyyy-MM-dd");
      Date ret = null;

      try
      {
         ret = dateFormatQuery.parse(date);
      }
      catch (ParseException e)
      {
         try
         {
            ret = dateFormatStored.parse(date);
         }
         catch (ParseException e1)
         {
            e.printStackTrace();
         }
      }

      return dateFormatRet.format(ret);
   }