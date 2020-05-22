private MyObject(ComplexData data)
{
    super(data);
}

public static MyObject createMyObject(String someParameter)
{
    ComplexData data = XMLParser.createData(someParameter);
    return new MyObject(data); 
}