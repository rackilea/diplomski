@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MyClass {

    @MyJsonIgnore
    private SomeType myField;

}