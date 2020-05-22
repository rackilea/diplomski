public class BaseClass {
    @SerializedName("Method")
    private String method;

    public void setMethod(String method){
        this.method = method;
    }

    public String getMethod(){
        return method;
    }

    public BaseClass(String method){
        this.method = method;
    }
}

public class DerivedClassA extends BaseClass{
    @SerializedName("FieldA")
    private String fieldA = "This is a derived class.";

    public DerivedClassA(){
        super("ClassA");
    }
}

public class DerivedClassB extends BaseClass{
    @SerializedName("FieldB")
    private String fieldB = "This is ANOTHER derived class.";

    @SerializedName("IntValue")
    private int intValue = 10;

    public DerivedClassB(){
        super("ClassB");
    }
}

public class ToSerializeClass{
    @SerializedName("TestString")
    private String testString = "TestStringValue";

    @SerializedName("DerivedClasses")
    private List<BaseClass> derivedClasses;

    public ToSerializeClass(List<BaseClass> derivedClasses){
        this.derivedClasses= derivedClasses;
    }
}