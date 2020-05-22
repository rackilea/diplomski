public interface Greeter {
    String getGreeting(String name);
}

public class EnglishGreeter implements Greeter {
    @Override
    public String getGreeting(String name) {
        return "Hello " + name + "!";
    }
}

public class SpanishGreeter implements Greeter {
    @Override
    public String getGreeting(String name) {
        return "Hola " + name + "!";
    }
}