public enum ExportRules {
    A_RULE((c) -> {//...}),
    //...
    private final Function<YamlConfiguration, ExportRule> func;
    private ExportRules( Function<YamlConfiguration, ExportRule> fun) {
        func = fun;
    }

    public ExportRule fromFileConfiguration(YamlConfiguration c) {
        return func.apply(c);
    }

}