public class SpringVaadinUI extends UI {

    @Autowired
    private SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        addStyleName(ValoTheme.UI_WITH_MENU);
        Panel panel = new Panel("Admin Panel");

        HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
        splitPanel.setSplitPosition(15, Unit.PERCENTAGE);
        panel.setContent(splitPanel);

        VerticalLayout navigationBar = new VerticalLayout();
        navigationBar.setPrimaryStyleName(ValoTheme.MENU_ROOT);
        navigationBar.addComponent(createNavigationButton("Home", FontAwesome.HOME, HomeView.NAME));
        navigationBar.addComponent(createNavigationButton("Teachers", FontAwesome.GROUP, TeachersView.NAME));
        splitPanel.setFirstComponent(navigationBar);

        CssLayout navigationDisplay = new CssLayout();
        splitPanel.setSecondComponent(navigationDisplay);

        Navigator navigator = new Navigator(this, navigationDisplay);
        navigator.addProvider(viewProvider);

        setContent(panel);
    }

    private Button createNavigationButton(String caption, FontAwesome icon, final String viewName) {
        Button button = new Button(caption, icon);
        button.setPrimaryStyleName(ValoTheme.MENU_ITEM);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }
}