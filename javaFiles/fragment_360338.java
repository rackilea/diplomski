@Component
@Primary
@Profile("CH")
public class SwissParser extends DefaultParser {
@Override
public void doSomething() {
    System.out.println("Ässe Ässe");
}