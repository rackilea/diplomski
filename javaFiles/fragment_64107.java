TimestampSerializer typeAdapter = new TimestampSerializer();

Reflections reflections = new Reflections(new ConfigurationBuilder()
    .setScanners(new SubTypesScanner(false))
    .setUrls(ClasspathHelper.forClassLoader(ClasspathHelper.contextClassLoader()))
    .filterInputsBy(new FilterBuilder().includePackage("com.package.dto", "com.package.other")));

Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);

for (Class<?> type : classes) {
    builder.registerTypeAdapter(type, typeAdapter);
}