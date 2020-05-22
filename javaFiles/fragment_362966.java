public class GluonApplication extends MobileApplication {

@Override
public void init() {

    addViewFactory(HOME_VIEW, () ->
    {

        StackPane root = new StackPane();
        root.getChildren().add(new Label("test"));

        View view = new View(root) {

            @Override
            protected void updateAppBar(AppBar appBar) {
                appBar.setTitleText("Home");
            }

        };
        view.setBottom(createBottomNavigation());
        return view;
    });

}

private BottomNavigation createBottomNavigation() {
    BottomNavigation bottomNavigation = new BottomNavigation();

    ToggleButton btn1 = bottomNavigation.createButton("View1", MaterialDesignIcon.DASHBOARD.graphic(), e -> showView("view1"));
    ToggleButton btn2 = bottomNavigation.createButton("View2", MaterialDesignIcon.AC_UNIT.graphic(), e -> showView("view2"));
    ToggleButton btn3 = bottomNavigation.createButton("View3", MaterialDesignIcon.MAP.graphic(), e -> showView("view3"));

    bottomNavigation.getActionItems().addAll(btn1, btn2, btn3);

    return bottomNavigation;
}

private void showView(String viewName) {
    MobileApplication.getInstance().switchView(viewName);
}