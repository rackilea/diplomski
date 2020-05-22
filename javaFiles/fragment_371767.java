public static int getNumberGreaterThanZero(String prompt)
  {
      int number = 0;
      while(number == 0)
      {
          System.out.println(prompt);
          String inputFromUser = input.nextLine();
          //check if input matches any negative or positive number
          if(inputFromUser.matches("-\\d+|\\d+"))
          {
              number = Integer.parseInt(inputFromUser);
              if(number <= 0)
              {
                  System.out.println(number + " is not greater than 0");
                  number = 0; //have them try again
              }
          }
          else
              System.out.println("Error - " + inputFromUser + " is not a valid number");

      }
      return number;
  }