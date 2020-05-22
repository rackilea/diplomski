public class MyData
{
    private static MyData _instance; 

    /* <Shared variables go here> */

    public String sharedVariable = "yay this is shared!";
    public String sharedVariable2 = "this is also shared!";
    public String myArray[][];

    /* </Variables> */

    public static MyData getMyData()
    {
        if(_instance == null)
            _instance = new MyData();

        return _instance;
    }
}