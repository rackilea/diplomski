public class DoSomethingVisitor extends EntityVisitor {
    @Inject private MyProperties props;

    @Override
    void visit(MyEntity entity)
    {
        String myProp = props.getProperty("my-prop");
        if(entity.getValue().equals(myProp))
        //...or whatever...
    }
}