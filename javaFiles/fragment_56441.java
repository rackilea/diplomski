boolean ask= false;
        while(!ask)
        {
           try
           {
               System.out.println("What is the age?");
               int age = input.nextInt();//does not read the newline character in your input created by hitting "Enter,"
               setAge(age);
               ask = true;
           }catch(InputMismatchException e) {
               System.out.println("Invalid input!");
               input.nextLine();//consumes the \n character
           }
        }//end while