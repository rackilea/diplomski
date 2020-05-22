public class Log {
    public interface ReadOnlyBuilder {
        Builder copy();
        Log build();
    }

    public static class Builder implements ReadOnlyBuilder {
        Builder tag(String tag){
          ...
        }
    }
}

public class SomeClass {
    public SomeClass(Log.ReadOnlyBuilder builder){
       log = builder.copy().tag("SomeClass").build();
    } //builder is as it was before the call, no side effect
}