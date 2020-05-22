class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        final String sentence = "Book on the table but not over there \nAlmost there\rHave fun!";
        System.out.println(sentence);
        final char[]letters=sentence.toCharArray();
        final StringBuilder reversed = new StringBuilder();
        final StringBuilder tmp = new StringBuilder();
        for(char c:letters)
        {
            if(Character.isWhitespace(c))
            {
                reversed.append(tmp.reverse()).append(c);
                if(0 < tmp.length())
                {
                    tmp.delete(0,tmp.length());
                }
            }
            else
            {
                tmp.append(c);
            }
        }
        if(0 < tmp.length())
        {
            reversed.append(tmp.reverse());
        }
        System.out.println(reversed);
    }
}