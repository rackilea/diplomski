@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        Button button = new Button("Click me", event -> {
            Object token = VaadinSession.getCurrent().getAttribute("token");
            if (token == null) {
                Notification.show("No token found in session. Now storing token = 123456");
                VaadinSession.getCurrent().setAttribute("token", "123456");
            } else {
                Notification.show("Found token in session: " + token.toString());
            }
        });
        add(button);
    }
}