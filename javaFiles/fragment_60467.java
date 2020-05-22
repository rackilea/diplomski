public class Car
{
    private Engine      e;
    private int         numWheels;
    private List<Wheel> wheels;

    public Car(Engine e, int numWheels, ...)
    {
       this.e         = e;
       this.numWheels = numWheels;
       this.wheels    = new ArrayList<>();

       for(int i = 0; i < this.numWheels; i++)
       {
           this.wheels.add(new Wheel(...));
       }
    }
}