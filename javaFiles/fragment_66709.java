public class className {

    private final List<String> ARRAY = new ArrayList<>(); // global variable 

    public void yourMethod(String value) {
        if (!ARRAY.contains(value)) {
            mail(value);
            ARRAY.add(value);
        }
    }
}