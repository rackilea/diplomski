public class FooDTOAdapter implements FooDTO {
    private final Foo foo;

    // ...
    String getColor() {
        return foo.getColor().toString();
    }
}

public class FooAdapter implements Foo {
    private final FooDTO dto;

    // ...
    Color getColor() {
        return Color.parse(dto.getColor());
    }
}