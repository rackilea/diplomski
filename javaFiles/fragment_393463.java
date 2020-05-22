class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        for(String s:"hello? bartender. can I have a drink!whiskey please.".replaceAll("(\\W)(\\s+)", "$1\n").split("\n"))
            System.out.println(s.substring(0, 1).toUpperCase()+s.substring(1));
    }
}