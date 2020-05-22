public class PojoPanel extends GenericPanel<Pojo> {
    private static final long serialVersionUID = 1L;

    public PojoPanel(String id) {
        super(id);
        add(new Label("property"));
    }

    protected void onInitialize() {
        super.onInitialize();
        add(new MultiLineLabel("Xproperty", new PropertyModel(getDefaultModel(), "property")));
    }

}