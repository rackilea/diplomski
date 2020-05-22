SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

          try {

       Date finalStartTime = format.parse(YOUR_OLD_DATE);
       Date finalEndTime = format.parse(YOUR_NEW_DATE);

      if (finalEndTime.after(finalStartTime)) {
                   //your code
                }
         } catch (ParseException e) {
                        }