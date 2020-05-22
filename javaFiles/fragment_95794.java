public Analyser(Class<C> enumType) {
    super();
    dist = new long [enumType.getEnumConstants().length];
}

...

Analyser<MyEnum> analyser = new Analyser(MyEnum.class);