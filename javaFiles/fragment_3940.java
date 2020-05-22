@Id
@NaturalId(mutable = false)
private final String id;
private final String name;
@Enumerated(EnumType.STRING)
private final Type type;

public static enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
}