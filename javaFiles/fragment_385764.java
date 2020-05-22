public class FracCalc
{
  public static void main(String[] args)
  {
    // String to test
    System.out.println(produceAnswer("5_3/4 - 6_7/8 + 3/4"));
    System.out.println(produceAnswer("-3_3/4 / -2_2/3"));
  }

  public static String produceAnswer(String input)
  {
    // Splits everything at every space
    String[] array = input.split(" ", 0);

    int allNumerators = 0;
    int allDenominators = 1;

    // Operation mode; 0=+; 1=-; 2=*; 3=/
    int mode = 0;

    // the for loop is used to identify and solve the the test
    for (int i = 0; i < array.length; i++)
    {
      String part = array[i];

      int numerator = 0;
      int denominator = 0;

      // If it has a _, then it's a whole + fraction
      if (part.contains("_"))
      {
        // Convert Int from start of part (0) to the character before _,
        // "55_30/40" -> 55

        int whole = Integer.parseInt(part.substring(0, part.indexOf("_")));

        // Convert Int from the character AFTER _ to the character before /,
        // "55_30/40" -> 30

        numerator = Integer.parseInt(part.substring(part.indexOf("_") + 1, part.indexOf("/")));

        // Convert Int from the character AFTER / to the end, "55_30/40" -> 40

        denominator = Integer.parseInt(part.substring(part.indexOf("/") + 1, part.length()));

        if (whole > 0)
          numerator += whole * denominator;
        else
          numerator = -numerator + whole * denominator;
      }
      // If no _, but still has a / AND it is not just the symbol "/", then it's
      // just a fraction
      else if (part.contains("/") && part.length() != 1)
      {
        numerator = Integer.parseInt(part.substring(0, part.indexOf("/")));
        denominator = Integer.parseInt(part.substring(part.indexOf("/") + 1, part.length()));
      } // else if(part.contains("*") && part.contains("/")){}
      else if (part.equals("/"))
      {
        mode = 3;
      }
      else if (part.equals("+"))
      {
        mode = 0;
      }
      else if (part.equals("-"))
      {
        mode = 1;
      }
      else if (part.equals("*"))
      {
        mode = 2;
      }
      // If neither _ nor /, then it's a whole
      else
      {
        numerator = Integer.parseInt(part);
        denominator = 1;
      }

      if (numerator != 0 && denominator != 0)
      {
        if (mode < 2)
        {
          if (denominator == allDenominators)
          {
            allNumerators += numerator;
          }
          else
          {
            // Cross multiply
            allNumerators *= denominator;

            if (mode == 0)
            {
              // Add
              allNumerators += numerator * allDenominators;
            }
            else
            {
              // Sub
              allNumerators -= numerator * allDenominators;
            }

            // Second part of cross multiply
            allDenominators *= denominator;
          }
        }
        // Multiplication
        else if (mode == 2)
        {
          allDenominators *= denominator;
          allNumerators *= numerator;
        }
        // Division
        else if (mode == 3)
        {
          // Reverse multiply because (1/2)/(1/2) -> (1*1)/(2*2)
          allNumerators = allNumerators * denominator;
          allDenominators = allDenominators * numerator;
        }

        // make sure denominators are +ve
        if (allDenominators < 0)
        {
          allNumerators = -allNumerators;
          allDenominators = -allDenominators;
        }
      }
    }

    // Simplifies fraction by checking to see id the top is bigger than bottom
    // 9/4 -> 2_1/4

    int allWholes = 0;
    if (allNumerators >= allDenominators)
    {
      allWholes = allNumerators / allDenominators;
      allNumerators %= allDenominators;
    }

    // consider implementing GCD to reduce num/den to simplest form

    if (allWholes == 0)
    {
      return (allNumerators + "/" + allDenominators);
    }
    else if (allNumerators == 0 || allDenominators == 0)
    {
      return allWholes + "";
    }
    else
    {
      return allWholes + "_" + (allNumerators + "/" + allDenominators);
    }
  }
}