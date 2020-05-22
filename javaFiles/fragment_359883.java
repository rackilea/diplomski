public class SimpleStringProperty {

    private StringBinding binding ;
    private boolean bound ;
    private String value ;

    // ...

    public String get() {
        if (bound) {
            value = binding.get();
        }
        return value ;
    }

    public void bind(StringBinding binding) {
        bound = true ;
        this.binding = binding ;
        value = binding.get();
    }
}