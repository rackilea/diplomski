public static Yaml instanceOfYaml() {
    DumperOptions options = new DumperOptions();
    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
    options.setDefaultScalarStyle(ScalarStyle.DOUBLE_QUOTED);
    final Yaml yaml = new Yaml(new Loader(), new Dumper(options), new Resolver() {
        /**
         * @see org.yaml.snakeyaml.resolver.Resolver#addImplicitResolvers()
         */
        @Override
        protected void addImplicitResolvers() {
            addImplicitResolver(Tag.BOOL, BOOL, "yYnNtTfFoO");
            // disable resolving of floats and integers
            // addImplicitResolver(Tags.FLOAT, FLOAT, "-+0123456789.");
            // addImplicitResolver(Tag.INT, INT, "-+0123456789");
            addImplicitResolver(Tag.MERGE, MERGE, "<");
            addImplicitResolver(Tag.NULL, NULL, "~nN\0");
            addImplicitResolver(Tag.NULL, EMPTY, null);
            addImplicitResolver(Tag.TIMESTAMP, TIMESTAMP, "0123456789");
            addImplicitResolver(Tag.VALUE, VALUE, "=");
        }
    });
    return yaml;
}