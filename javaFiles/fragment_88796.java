abstract class Base{
    public void doSomething(){}
}

public class B0 extends Base{
    @Override
    public void doSomething(){//actually do something}
} 

public class B1 extends Base{}