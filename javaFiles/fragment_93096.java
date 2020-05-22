// ConfigParam.java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigParam { String description(); }

// Configuration.java
public class Configuration {
    @ConfigParam("Define a source directory")
    String src;
    @ConfigParam("Define a destination directory")
    String dst;
}

// loading code
Yaml yaml = new Yaml(new Constructor(Configuration.class));
Configuration config = yaml.loadAs(input, Configuration.class);

// help generation code
System.out.println("Your program can be ran with the following options:")
for (Field field: Configuration.class.getFields()) {
    ConfigParam ann = field.getAnnotation(ConfigParam.class);
    if (ann != null) {
        System.out.println(String.format("--%s  %s", field.getName(), ann.description());
    }
}