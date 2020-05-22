public interface Foo {
    Long getId();
    Color getColor();
    LocalDateTime getLastModified();
}

public interface FooDTO {
    Long getId();
    String getColor();
    LocalDateTime getLastMofified();
}