Scanner input= new Scanner(System.in);
System.out.print("Enter Year:");
int year = input.nextInt();
Calendar cal = Calendar.getInstance();
for (int i=0; i<12; i++) {
    cal.set(year, i, 1);
    System.out.printf( "the first day of %s is %s\n",
            cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()),
            cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()) );
}//end for i