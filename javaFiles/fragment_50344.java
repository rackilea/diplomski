public class BaseClass {
...
    setClient ()
    {
        this.myClient = BaseClass.getClient();
    }
...
}

public class MyClass extends BaseClass {
...
    setClient ()
    {
        this.myClient = MyClass.getClient();
    }
...
}