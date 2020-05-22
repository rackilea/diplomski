public class Root {
    @SerializedName("objs")
    public List<Obj> objects;
}

public class Obj {
    @SerializedName("obj1")
    public Obj1 obj1;
}

public class Obj1 {
    @SerializedName("ID1")
    public int ID1;

    @SerializedName("ID2")
    public int ID2;
}