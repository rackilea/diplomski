import org.flywaydb.core.Flyway;
public class TestClass {
public static void main(String args[]) {
    Flyway flyway = new Flyway();
    for (String location : flyway.getLocations()) {
        System.out.println(location);
    }
    flyway.setDataSource("jdbc:h2:~/test", "sa", "");
    System.out.println("Result: " + flyway.migrate());
}
}