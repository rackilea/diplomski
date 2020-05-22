public class MyParameters {
    private int id;
    private float x;
    private float y;
    private String name;

    public MyParameters(int id, float x, float y, String name) {
        // ...
    }

    // + getters, setters
}

// ...

List<MyParameters> myParameters = new ArrayList<>();
myParameters.add(new MyParameters(2, 4.5, 8.9, "Name"));