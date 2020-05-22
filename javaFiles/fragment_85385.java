int midterm;
  System.out.printLn("Enter midterm grade");
  do
  { 
      try {
          string s = in.nextLine();
          midterm = Integer.parseInt(s);
          break;
      }
      catch (Exception e)
      {
          System.out.printLn("Couldn't parse input, please try again");
      }
  }
  while (true);