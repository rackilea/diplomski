public class Target {

    // Find a bean which name is "fooOne" , and call this setter to inject 
    public void setFooOne(Foo fooOne) {}

    // Find a bean which name is "fooTwo" , and call this setter to inject (As no beans called fooTwo in your example , it will be null) 
    public void setFooTwo(Foo foo) {}

    //Find a bean which name is "bar" , and call this setter to inject (As no beans called bar in your example  , it will be null)   
    public void setBar(Bar bar) {}      
}