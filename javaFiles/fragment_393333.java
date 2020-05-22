@Service
public class Sample {

    public final int DEFAULT_GREETING = "Hi";

    public void test(Greet greet) {
        greet.setInitial(DEFAULT_GREETING);
    }
}