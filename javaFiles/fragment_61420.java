public class Sample 
{
    public static void main(String[] args) throws Exception 
    {
        //part 1
        int i=1;
        // i++ means i is returned (which is i = 1), then incremented, 
        //  therefore i = 1 because i is incremented to 2, but then reset 
        //  to 1 (i's initial value)
        i=i++;
        // i is incremented, then returned, therefore i = 2
        i=++i;
        // again, first i is returned, then incremented, therefore i = 2 
        //  (see first statement)
        i=i++;
        System.out.println(i);

        //part 2
        i=1;
        // first i is returned then incremented, so i = 2, a = 1
        int a=i++;
        // i is incremented then returned, so i = 3 and a = 3
        a=++i;
        // i is first returned, then incremented, so a = 3 and i = 4
        a=i++;
        System.out.println(a+"\n"+i);
    }
}