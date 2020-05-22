public static void main(String[] args)
  {
    String first = "abadcd";
    String second = "Dcdbua";
    String third = "dcdabA";
    System.out.println("Should be false = " + isReverse(first, second));
    System.out.println("Should be true = " + isReverse(first, third));
  }

  public static boolean isReverse(String first, String second)
  {
    System.out.println("1=" + first + " / 2=" + second);
    if (first.length() != second.length())
    { // If string are not of equal length, impossible to be reverses
      return false;
    }

    // Stopping condition
    if (first.length() == 0 && second.length() == 0)
    {
      return true;
    }

    String check1 = "" + first.charAt(first.length() - 1);
    String check2 = "" + second.charAt(0);
    if (check1.equalsIgnoreCase(check2))
    { // gets the 1st char of first and last char of 2nd to see if it matches
      String temp1 = first.substring(0, first.length() - 1); // shorten the string by escluding first char
      String temp2 = second.substring(1, second.length()); // shorten the string by last char

      return isReverse(temp1, temp2);
    }
    return false; // reaches here after goes through
  }