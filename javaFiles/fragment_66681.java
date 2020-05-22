public abstract class EngineClass
{
    public void startEngine() { ... }  
} // EngineClass

public abstract class CarClass
{
    protected EngineClass engine;  

    public CarClass()
    {
      // ...
    }

    public EngineClass createEngine()
    {
      EngineClass Result = new EngineClass();
      return Result;
    }

    public void start()
    {
      this.Engine = createEngine();
    }
} // CarClass

public class StreetCarClass extends CarClass
{
     public StreetCarClass()
     {
       // ...
     }

    @override
    public EngineClass createEngine()
    {
      EngineClass Result = new StreetCarEngineClass();
      return Result;
    }
} // StreetCarClass 

public class OffRoadCarClass extends CarClass
{
     public OffRoadCarClass()
     {
       // ...
     }

    @override
    public EngineClass createEngine()
    {
      EngineClass Result = new OffRoadCarEngineClass();
      return Result;
    }
} // OffRoadCarClass 

public class ExampleClass
{
    public static main()
    {
      EngineClass OffRoadCar = new OffRoadCarClass();
      OffRoadCar.start();
    }
} // OffRoadCarClass