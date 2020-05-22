field.getAlias().transform(new Function(String, String) {
    @Override
    public String apply(String alias) {
        return " AS " + alias;
    }
}).or("");