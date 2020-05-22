for (i = 1; i<10; i++) {

             // New calculations
             monthlyInterest = (balance * monthlyRate);
             principal = (monthlyPayment - monthlyInterest);
             balance = (balance - principal);

             // Display interest, principal, and balance
             System.out.println(df.format(principal) + "\t\t" + df.format(monthlyInterest) + "\t\t" + df.format(balance));

         } // end loop i