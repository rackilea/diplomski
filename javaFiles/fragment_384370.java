public class RestrictedContainer extends WebMarkupContainer implements RestrictedComponent {
    private final Integer function;
    public RestrictedContainer(String id, IModel model, final Integer function) {
        super(id, model);
        this.function = function;
    }
    public RestrictedContainer(String id, final Integer funcionalitat) {
        super(id);
        this.function = function;
    }
    public Integer getFunction() {
        return function;
    }
}