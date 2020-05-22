Scanner input = new Scanner(System.in);


    String color = "";
    int number = -1;


        while(!color.equalsIgnoreCase("Black") || !color.equalsIgnoreCase("Red") && (number <= 0 || number >= 10))
        {  
                try
                {
                    System.out.print("Please choose Black or Red....and a number from 1-10: ");
                    color = input.next();
                    number = input.nextInt();
                }
                catch(InputMismatchException e) //More specific error
                {
                    e.getMessage(); 
                    System.out.println("Invalid entry, most specific. ");

                }
                catch(Exception e) //less specific general error
                {
                    e.getMessage();
                    System.out.println("unknown entry error.");
                }

        }

         // \n puts that "quote" on the next line
        System.out.println("Color chose: " + color + "\nnumber chose: " + number);