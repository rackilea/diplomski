public class InputProcessor extends AbstractProcessor<String, String> {
    @Override
    public void process(String key, String value) {
        try {
            context().forward(key, Integer.parseInt(value), To.child("child1"));
            context().forward(key, value, To.child("child2"));
        }
        catch (NumberFormatException nfe) {
            context().forward(key, value, To.child("child2"));
        }
    }
}