public class DateTimeAdapter extends XmlAdapter<String, DateTime>{
   private static DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

   @Override
   public DateTime unmarshal(String vt) throws Exception {
       return dtf.parseDateTime(vt);
   }

   @Override
   public String marshal(DateTime bt) throws Exception {
       return dtf.print(bt);

   }
}