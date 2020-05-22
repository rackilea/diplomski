public static void main (String [] args)    
{
    String answer = null;  // you have no answer yet...
    do {   // ... but you want to execute your stuff at least once
        Scanner in = new Scanner(System.in);
        int hour1, minute1, hour2, minute2;

        System.out.print("Please enter the first time: ");
        int time1 = in.nextInt();
        System.out.println();
        hour1 = time1 / 100;
        minute1 = time1 % 100;

        System.out.print("Please enter the second time: ");
        int time2 = in.nextInt();
        System.out.println();
        hour2 = time2 / 100;
        minute2 = time2 % 100;

        System.out.println("Time elapsed: " + (Math.abs(hour1 - hour2) + " Hours, " + (Math.abs(minute1 - minute2) + " Minutes \n")));

        System.out.print("Do you want to quit? (y/n): ");
        answer = in.next();
    } while (!answer.equalsIgnoreCase("n"));

}