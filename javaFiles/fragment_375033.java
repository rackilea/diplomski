public class abc
{
    //Declare class-scoped variables, accessible by all class methods.  Could be public or private.
    public int startAngle;

    //constructor - initialize vars here
    public abc()
    {
        startAngle = 90;
    }

    public void method()
    {
        int angleVar = startAngle + 10; //startAngle will be 90.
        //angleVar will be 100;
        //angleVar can only be accessed inside this method.
    }
}