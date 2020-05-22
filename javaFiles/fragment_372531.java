public static double rate (double cash, String jobrole)
                                    // ^
 {
    switch (jobrole)
    {
       case "1": return 5.75;
       case "2": return 5.75*1.1;
       case "3": return 5.75*1.25;
       case "4": return 5.75*1.42;
       default: return 0; // some default.
    }
}