@Data
public class Example {

    @JsonView(Views.Foo.class)
    private int a = 1;

    @JsonView(Views.Bar.class)
    private int b = 2;

    private int c = 3;
}