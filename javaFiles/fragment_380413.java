@SpringView(name = HomeView.NAME)
public class HomeView extends VerticalLayout implements View {
    public static final String NAME = "";

    @PostConstruct
    void init() {
        addComponent(new Label("Home"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // meh, nothing special to do here
    }
}