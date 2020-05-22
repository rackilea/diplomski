public class ModelProxy {

    private final Model model;

    public ModelProxy(final Model model) {
        this.model = model;
    }

    public String getName() {
        return model.getName();
    }

}