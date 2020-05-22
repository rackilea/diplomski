if (num == 1) { //if CHECKING is selected
                    //enter amount to be deposited
                    System.out.println("------------------------");
                    System.out.println("Enter amount to deposit in checking account: ");
                    System.out.println("------------------------");
                    amount = scan.nextDouble();

                    //ask if they want to continue with transaction
                    System.out.println("------------------------");
                    System.out.println("Would you like to continue this transaction?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                    System.out.println("------------------------");
                        num = scan.nextInt();

                    // Add the amount to the checking balance
                    checkingBalance += amount;
                    System.out.println("------------------------");
                    System.out.println("Your checking account's balance is " + checkingBalance);
                    System.out.println("------------------------");

                } else if (num == 2) { //if SAVINGS is selected
                    //enter amount to be deposited
                    System.out.println("------------------------");
                    System.out.println("Enter amount to deposit in savings account: ");
                    System.out.println("------------------------");
                    amount = scan.nextDouble();

                    //ask if they want to continue with transaction
                    System.out.println("------------------------");
                    System.out.println("Would you like to continue this transaction?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                    System.out.println("------------------------");
                        num = scan.nextInt();

                        if (num == 1) {
                            // Add the amount entered to the savings balance
                            savingsBalance += amount;
                            System.out.println("------------------------");
                            System.out.println("Your savings account's balance is " + savingsBalance);
                            System.out.println("------------------------");
                        **} else if (num == 2) {
                            //EMPTY NEEDS CODE
                        }**
                }