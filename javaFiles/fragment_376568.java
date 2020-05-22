public static void main(String[] args)
{
    String cleaned = "abcXabcXabc";
    char remove = 'X';

    int loc;
    while ((loc = cleaned.indexOf(remove)) != 1)
    {
        String part1 = cleaned.substring(0, loc);
        String part2 = cleaned.substring(loc + 1);
        cleaned = part1 + part2;
    }

    System.out.println("after: " + cleaned);
}