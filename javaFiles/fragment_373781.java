enum Type {

    TYPE1(1, Arrays.asList(SubType.SUBTYPE1, SubType.SUBTYPE2)),

    TYPE2(2, Arrays.asList(SubType.SUBTYPE3),
    ...

    private int constant;
    public final List<SubType> subtypes;

    Type(int constant, List<SubType> subtypes) {
        this.constant = constant;
        this.subtypes = subtypes;
    }
}

enum SubType {

    SUBTYPE1(1),

    SUBTYPE2(2),

    SUBTYPE3(3),
    ...

    private int constant;

    SubType(int constant) {
        this.constant = constant;
    }
}