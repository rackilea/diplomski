public static String scanStr(String prefix, String data)
{
    try (Scanner s = new Scanner(data))
    {
        while (s.hasNextLine())
        {
            if (s.findInLine(prefix + " (\\S*)(.*)") != null)
            {
                return s.match().group(1);
            }
            s.nextLine();
        }
        return null;
    }
}