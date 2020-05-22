@Root(name = "example")
@Convert(value = ListConverter.class) // Specify the Converter that's used for this class
public class Example
{
    // This element will be set with the values from 'box-headers' element
    @ElementList(name = "box-headers")
    private List<String> values;


    // This constructor is used to set the values while de-serializing
    // You can also use setters instead
    Example(List<String> values)
    {
        this.values = values;
    }

    //...
}