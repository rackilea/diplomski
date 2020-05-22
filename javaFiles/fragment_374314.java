public class Obj1 {
    public int id;
    public String name;
    @JsonIgnoreProperties("obj1list")
    public Obj2 obj2;
}

public class Obj2 {
    public int id;
    public String name;
    @JsonIgnoreProperties("obj2")
    public List<Obj1> obj1list;
}