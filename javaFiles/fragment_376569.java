public static void main(String[] args)
{
    String cleaned = "abcXabcXabc";
    // Notice this is now a String
    String remove = "X";

    cleaned = cleaned.replace(remove, "");

    System.out.println("after: " + cleaned);
}