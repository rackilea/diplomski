public class XY {

    @Inject
    @ClassType(ClassImplName.CLASS_ONE)
    @MyClassType
    private MyInterface myClassOne;

    @Inject
    @ClassType(ClassImplName.CLASS_TWO)
    @MyClassType
    private MyInterface myClassTwo;

    // Other methods using injected beans ...
}