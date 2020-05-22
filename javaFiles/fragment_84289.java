int option, quantity, confirm;
        float childTotal;
        float adultTotal;
        float seniorTotal;

        final double childCost = 18;
        final double adultCost = 36;
        final double seniorCost = 32.50;

        boolean continueLoop = true;
        char resume;

        Scanner input = new Scanner(System.in);
        while(continueLoop){
                System.out.println("1 = Child (4-6 yrs)");
                System.out.println("2 = Adult (16+ yrs)");
                System.out.println("3 = Senior (60+ yrs)" + "\n");

                System.out.println("Enter your option:" );
                option=input.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Enter total No of tickets for Child:" );
                        quantity=input.nextInt();

                        System.out.println("You are purchasing " + quantity + " child tickets");

                        System.out.println("Press 1 to confirm");
                        confirm=input.nextInt();

                        break;

                    case 2:
                        System.out.println("Enter total No of tickets for Adult:" );
                        quantity=input.nextInt();

                        System.out.println("You are purchasing " + quantity + " adult tickets");

                        System.out.println("Press 1 to confirm");
                        confirm=input.nextInt();

                        break;

                    default:
                        System.out.println("Enter total No of tickets for Senior:" );
                        quantity=input.nextInt();

                        System.out.println("You are purchasing " + quantity + " senior tickets");

                        System.out.println("Press 1 to confirm");
                        confirm=input.nextInt();

                        break;
                }

                if (confirm !=1) {
                    System.out.println("Incorrect key! User to go back to main menu");
                }


              System.out.println("Do you wish to continue? (Y/N) ");
              resume = input.next().charAt(0);

              if (resume == 'y' || resume == 'Y') {
              }else{
                  continueLoop = false;
                  switch (option) {
                    case 1:
                        childTotal=(int) ((double) quantity*childCost) ;
                        System.out.println("Total amount for child tickets: $" + childTotal);
                        break;
                    case 2:
                        adultTotal=(int) ((double) quantity*adultCost) ;
                        System.out.println("Total amount for adult tickets $" + adultTotal);
                        break;
                    default:
                        seniorTotal=(int) ((double) quantity*seniorCost);
                        System.out.println("Total amount for senior tickets $" + seniorTotal);
                        break;
                  }
              }
        }
    }