public static void main (String[]args)
  {
    String name = null;
    String name2 = null;
    Integer age = null;
    Integer age2 = null;
    Scanner scan = new Scanner(System.in);
    while (scan.hasNext())
      {
    try
    {
      if (name == null)
        {
          System.out.println("Please provide name: ");
          name = getNameOrFail(scan);
          System.out.println("Name set: " + name);
        }
      if (age == null)
        {
          System.out.println("Please provide age: ");
          age = getAgeOrFail(scan);
          System.out.println("Age set: " + age);
        }
      if (name2 == null)
        {
          System.out.println("Please provide name2: ");
          name2 = getNameOrFail(scan);
          System.out.println("Name2 set: " + name2);
        }
      if (age2 == null)
        {
          System.out.println ("Please provide age2: ");
          age2 = getAgeOrFail (scan);
          System.out.println ("Age2 set: " + age2);
        }
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage ()); // Print the message put int Exception(message) constructor
      scan.nextLine(); // Flush the Scanner cache
    }
      }
  }

  public static String getNameOrFail(Scanner scan) throws Exception
  {
    if (scan.hasNextInt())
      throw new Exception("Need String got Integer");
    return scan.next();
  }

  public static Integer getAgeOrFail(Scanner scan) throws Exception
  {
    if (!scan.hasNextInt())
      throw new Exception("Need Integer got String");
    return scan.nextInt();
  }