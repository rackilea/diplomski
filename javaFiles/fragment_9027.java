@Data
@JsonView(Views.Foo.class)
public static class Example {

    private int a = 1;

    @JsonView(Views.Bar.class)
    private int b = 2;

    private int c = 3;
}