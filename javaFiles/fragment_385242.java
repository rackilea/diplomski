System.out.print("Enter month (valid values are from 1 to 12): ");
        Scanner monthScan = new Scanner(System.in);
       int monthInput = monthScan.nextInt();
        // If the month input is below 1 or greater than 12, prompt for another value
        while((monthInput<1 || monthInput>12) )
        {
            System.out.print("Invalid value! Enter month (valid values are from 1 to 12): ");

            monthInput = monthScan.nextInt();
        }
        System.out.println("I am here");