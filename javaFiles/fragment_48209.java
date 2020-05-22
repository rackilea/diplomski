class test
{


public static void main(String args[])
    {
        System.out.println(runlength("aaabbc"));
    }
static String runlength(String s)
{
    String current="";
    int count = 1;
    char[] c = s.toCharArray();
    for(int i = 1; i < c.length; i++)
    {
        if (c[i]==c[i-1])
            count++;

        else 
        {
            current = current + count + Character.toString(c[i-1]);
            count = 1;
        }
    }
    return current + count + Character.toString(c[c.length-1]);
}
}