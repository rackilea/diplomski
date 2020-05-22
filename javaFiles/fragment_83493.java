@SpringBootApplication
 public class Main {
     public static void main(String... args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("org.fandingo.blah.blah");
        ctx.registerShutdownHook();
 }