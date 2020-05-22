public static class FooResultTransformer implements ResultTransformer {

    @Override
    public List transformList(List list) { return list; }

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        List<String> aliasList = Arrays.asList(aliases);
        Foo foo = new Foo();
        foo.row_id = ((Number) getValue(tuple, aliasList, "row_id", 0L))
            .longValue();
        foo.name = (String) getValue(tuple, aliasList, "name", null);
        return foo;
    }

    private static Object getValue(Object[] tuple, List<String> aliases,
            String field, Object defaultValue)
    {
        // unchecked for berevity
        if (tuple[aliases.indexOf(field)] == null) {
            return defaultValue;
        }
        return tuple[aliases.indexOf(field)];
    }

}