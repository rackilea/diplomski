public enum ExportRules {
    A_RULE {
         @Override public ExportRule fromFileConfiguration(YamlConfiguration c) {...}
    },
    //...
    public abstract ExportRule fromFileConfiguration(YamlConfiguration c);

}