public static Date getTwitterDate(String date) throws ParseException {

  final String TWITTER="EEE MMM dd HH:mm:ss ZZZZZ yyyy";
  SimpleDateFormat sf = new SimpleDateFormat(TWITTER);
  sf.setLenient(true);
  return sf.parse(date);
  }

public static void main (String[] args) throws java.lang.Exception
    {
      System.out.println(getTwitterDate("Thu Dec 3 18:26:07 +0000 2010"));          
    }