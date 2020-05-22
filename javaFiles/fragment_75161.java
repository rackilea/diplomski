package enumtest;

enum Junk
{
    Wrapper(0),
    SilverCoins(150),
    Dresser(250),
    Sofa(250),
    ChippedBat(0),
    BrokenMicrowave(0),
    SilverWare(35),
    Newspapers(0),
    Book(20),
    Clothes(60),
    Plates(40),
    Cups(25),
    DiningTable(200),
    Chair(30),
    BoxOfPaper(10),
    BucketofPaint(10),
    Watch(30);

    private int value;

    private Junk(int value)
    {
        this.value=value;
    }

    public int getValue()
    {
        return(value);
    }
}

final public class Main
{
    public static void main(String...args)
    {
        int sum=0;

        for(Junk o:Junk.values())
        {
            sum+=o.getValue();
        }

        System.out.println("sum  = "+sum);
    }
}