do {
      System.out.println("Please enter your hourly pay rate");
      String str = user_input.nextLine();
      try {
        payment = Integer.parseInt(str.trim());
        if (payment <= 0) {
          System.out.println("Please enter a valid input");
          continue;
        }
        System.out.println("Your hourly pay rate is " + payment + " dollars p/h");
        break;
      }
      catch (NumberFormatException e) {
        System.out.println("Please enter a valid input");
      }
    } while (true);