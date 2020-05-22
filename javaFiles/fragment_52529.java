class TestEnum {
    private final List<Enum> values;
    private final Function<String,Enum> parse;
    public TestEnum(List<Enum> v, Function<String,Enum> p) {
        values = v;
        parse = p;
    }
    public List<Enum> getValues() { return values; }
    public Function<String,Enum> getParse() { return parse; }
}
List<TestEnum> allEnums = Arrays.asList(
    new TestEnum(Arrays.asList(FileFormatCodeEnum.values()), s -> FileFormatCodeEnum.parse(s))
,   new TestEnum(Arrays.asList(RoleTypeCodeEnum.values()), s -> RoleTypeCodeEnum.parse(s))
);