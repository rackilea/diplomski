...
public static void main(String[] args) {
    Stream.of(System.getProperty("sun.boot.class.path")
            .split(File.pathSeparator))
            .filter(s -> s.endsWith("rt.jar"))
            .forEach(System.out::println);
    ...