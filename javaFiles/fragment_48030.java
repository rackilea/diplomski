public class AAA
{
    public boolean equals(Object other)
    {
        System.out.println("objectA");
        return true;
    }
}

public class BBB extends AAA
{
    public boolean equals(Object other)
    {
        System.out.println("objectB");
        return true;
    }
}

public static void main(String args[])
{   
    AAA ab=new BBB();
    ab.equals(ab);
}