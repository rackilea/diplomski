// driver code
Configuration config = Configuration.create();
config.setLong("foo.bar.somelong",1337);
...

// mapper code
public class SomeMapper ... {
    private long someLong = 0;
    public void setup(Context context) {
        Configuration config = context.getConfiguration();
        someLong = config.getLong("foo.bar.somelong");
    }
}