Optional<ToolProvider> jar = ToolProvider.findFirst("jar");
jar.get().run(
        System.out,
        System.err,
        "--describe-module",
        "--file",
        "path/to/the/jar/for/example/commons-lang3-3.6.jar"
);