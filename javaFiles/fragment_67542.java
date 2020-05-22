public abstract class CodeBundle { // or even an interface
    public abstract String str(String id);
}

public final class JAppFramework extends CodeBundle {
    private static final CodeBundle INSTANCE = new JAppFramework();

    // private constructor
    private JAppFramework() {
        // whatever
    }

    // get the instance
    public static CodeBundle getInstance() { return INSTANCE; }

    // Implement str() here
}

// Create other singletons as needed