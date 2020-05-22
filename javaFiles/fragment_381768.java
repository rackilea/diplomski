public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);
        ParsingService service = context.getBean(ParsingService.class);

        for (String arg : args) {
            List<Order> listOfParsedObjects = service.parse(arg);
            listOfParsedObjects.forEach(System.out::println);
        }
    }
}

@Configuration
@ComponentScan(basePackages = "your.root.package")
public class AppConf {
    // Do something here
}