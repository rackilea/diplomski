public class ProcTest {
    @Test
    public void run() {
        String basePath = "/path/to/src/folder/";
        List<String> args = asList("Haha", "MyInterface", "StringImpl")
                .stream()
                .map(s -> basePath +"bar/" + s + ".java")
                .collect(Collectors.toList());
        args.addAll(0, asList("-processor", Proc.class.getName()));
        String[] flags = args.toArray(new String[3]);
        ToolProvider.getSystemJavaCompiler()
                    .run(System.in, System.out, System.err,  flags);
    }
}