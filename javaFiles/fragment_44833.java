public Dictionary<MyEnum, Quad> my_quads = new Dictionary<MyEnum, Quad>();

public static enum MyEnum
{
    Resource1 = 0
    Resource2 = 1
    Resource3 = 2
}

public Quad getQuad(MyEnum resource_index)
{
    return my_quads[resource_index];
}