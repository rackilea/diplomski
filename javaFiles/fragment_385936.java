static String amPM;// will hold am/pm for standard time
static String traditionalTime;// will store traditional time from user
static int mins1, mins2, hours;// will store hours and minutes

public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// user
                                                                                // input

    int tryAgain = 1;// will initial do-while loop
    System.out.println("Standard Time to Traditional Time Converter");
    System.out.println("===========================================");
    do {
        System.out.println();
        System.out.println("Input a time in Standard Form (HH:MM:SS):");
        String standardTime = br.readLine();// user inputs time in standard
                                            // form
        System.out.println();

        do {
            if ((standardTime.length()) != 8) {
                System.out.println("Invalid time entered.");
                System.out
                        .println("Input a time in Standard Form that has this form HH:MM:SS ...");
                standardTime = br.readLine();// user inputs time in standard
                                                // form
                System.out.println();
            }
        } while ((standardTime.length()) != 8);

        convertToTraditional(standardTime);
//          if (hours >= 12) {
//              System.out.println(standardTime + " is equivalent to "
//                      + traditionalTime + " PM");
//          }
//          if (hours < 12) {
//              System.out.println(standardTime + " is equivalent to "
//                      + traditionalTime + " AM");
//          }
        System.out.println(standardTime + " is equivalent to "
                + traditionalTime);

        System.out.println();
        System.out.println("Enter 1 to try again.");
        tryAgain = Integer.parseInt(br.readLine());// user decides to try
                                                    // again
    } while (tryAgain == 1);// will repeat if user enters 1

}// closes main body

public static void convertToTraditional(String standardTime) {
    String strHours = standardTime.substring(0, 2);                         // "13"
    String strMin = standardTime.substring(3, 5);           
    hours=Integer.parseInt(strHours);
    if(hours>12)
    {

        hours=hours-12;
        traditionalTime=Integer.toString(hours)+":"+strMin+" PM";
    } else
    {

        traditionalTime=strHours+":"+strMin+" AM";
    }



}