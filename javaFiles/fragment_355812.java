class Main {

  public static void main(String[] args) {

        System.out.println( convert("yyyyMMdd") );
        System.out.println( convert("yyyy-MM-dd") );
        System.out.println( convert("yyyyMMdd HH:mm") );
        System.out.println( convert("yyyyMMdd HH:mm:ss") );
        System.out.println( convert("yyyy MMM dd") );


  }

  public static String convert(String original) {

         String Output = original;
         System.out.println("");
         System.out.println(original);

        // Year
         Output = Output.replaceAll("yyyy", "[0-9]{4}");
         Output = Output.replaceAll("yy", "[0-9]{2}");

        // Month
         Output = Output.replaceAll("MMMM", "(?:January|Feburary|March|April|May|June|July|August|September|October|November|December)");
         Output = Output.replaceAll("MMM", "(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)");
         Output = Output.replaceAll("MM", "(?:0[0-9]|1[0-2])");   // 00-12

        // Day
         Output = Output.replaceAll("dddd", "(?:Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday)");
         Output = Output.replaceAll("ddd", "(?:Mon|Tue|Wed|Thu|Fri|Sat|Sun)");
         Output = Output.replaceAll("dd", "(?:[0-2][0-9]|3[01])");  //  00-31

        // Hour
         Output = Output.replaceAll("HH", "(?:[0-1][0-9]|2[0-3])");  // 24 hour format
         Output = Output.replaceAll("hh", "(?:0[0-9]|1[0-2])");  // 12 hour format

        // Minutes
         Output = Output.replaceAll("mm", "[0-5][0-9]");     // 0-59

        // Seconds
         Output = Output.replaceAll("ss", "[0-5][0-9]");    // 0-59


        // Meridian
         Output = Output.replaceAll("EE", "(?:AM|PM)");     // AM or PM
         Output = Output.replaceAll("ee", "(?:am|pm)");     // am or pm

     //   System.out.println(Output);
    return Output; 
  }

  }