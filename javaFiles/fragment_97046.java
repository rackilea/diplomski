class Chat {

   private Long unixTime;

   // another code

   public Long getUnixTime() {
      return unixTime;
   }

   public String convertedUnixTimeToString(String format) {
      // Also need to add some format validation     
      if(format == null) {
         // do some action, like trowing exception, or setting default value in format
      } 

      Date time = new java.util.Date(unixTime*1000L);
      SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);

      return sdf.format(time);
   }

}