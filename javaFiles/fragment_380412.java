@SpringView(name = TeachersView.NAME)
public class TeachersView extends VerticalLayout implements View {
    public static final String NAME = "Teachers";

    private Label title = new Label("Teachers view");

    @PostConstruct
    void init() {
        addComponent(title);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // recreate or reload stuff here
        title.setValue("Teachers view reloaded @ " + new Date());
    }
}