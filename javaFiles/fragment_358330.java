@SpringBootApplication
public class MainApp {

    public static void main(String... z) {
        ApplicationContext ctx = SpringApplication.run(MainApp.class, z);
        Student student = ctx.getBean("student", Student.class);

        student.getAge();
        student.getGame();
        student.printThrowException();
    }
}