Scanner da= new Scanner(System.in);
d= getDay (da);

private int getDay (Scanner da) {

    int day = 0;
    while (day <= 0 || day > 31) {  // tricky logic required here
       System.out.println ("Enter day between 1 and 31");
       day = da.nextInt ();
    }
    return day;
}