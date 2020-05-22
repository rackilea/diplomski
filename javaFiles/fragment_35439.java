class MyTesting
{
  public static void main (String[] args) throws java.lang.Exception
  {
    capitalizeEveryNthWord("this is a sentence that is being tested", 3, 3);
  }

  // Take a single-spaced <sentence>, and capitalize every <n> word starting   with <offset>.
  public static String capitalizeEveryNthWord(String sentence, Integer offset, Integer n) {
    String[] parts = sentence.split(" ");
    String retVal = "";
    for (int idx = 0; idx < offset; idx++)
    {
        retVal += parts[idx] + " ";
    }
    for (int idx = offset; idx < parts.length; idx++)
    {
        if ((idx - offset) % n == 0) // added parantheses
        {
            retVal += Character.toUpperCase(parts[idx].charAt(0)) + parts[idx].substring(1) + " "; // make the first character uppercase.
        }
        else
        {
            retVal += parts[idx] + " ";
        }
    }
    System.out.println(retVal);
    return retVal;
  }
}