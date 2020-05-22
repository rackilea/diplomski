public class Example {

    // Do not place Android context classes in static fields; this is a memory leak 
    // (and also breaks Instant Run)
    public static Context context;

    // Do not place Android context classes in static fields (static reference to 
    // Example which has field context pointing to Context); this is a memory leak 
    // (and also breaks Instant Run)
    public static Example INSTANCE;

    private Example() { INSTANCE = this; }

    static { new Example(); }

}