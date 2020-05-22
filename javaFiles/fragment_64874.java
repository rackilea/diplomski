import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    Logger log = LoggerFactory.getLogger(HelloWorld.class);

    public String speak(String speech) {
        log.info("Java says: {}", speech);

        return speech;
    }

    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();

        hello.speak("Hello world");
    }
}