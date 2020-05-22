public class Object {

    @SerializedName("field1")
    public String fieldOne;

    @SerializedName("field2")
    public String fieldTwo;

    @SerializedName("field3")
    public String fieldThree;

    @SerializedName("field4")
    public String fieldFour;
}

public class Name {

    @SerializedName("object1")
    public Object obj;
}

public class GsonObj {

    @SerializedName("Name")
    public Name name;
}