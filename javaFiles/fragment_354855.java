public class MyParamBlob
{
    ...
    public MyParamBlob(double[] values)
    {
        setAll(values);
    }
    // getters and setters as appropriate
    ...
    public void setAll(double[] values)
    {
        myReadableParameter = values[0];
        anotherParameter = values[1];
        // etc.
    }
}