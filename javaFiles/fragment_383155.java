public class Complex {
    private final List<String> sideEffects = new ArrayList<>();

    protected void sideEffect(String name) {
        sideEffects.add("Side effect for " + name);
    }

    public int call(String name) {
        sideEffect(name);
        return name.length();
    }

    public List<String> getSideEffects() {
        return sideEffects;
    }
}