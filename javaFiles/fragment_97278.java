@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        Button button = new Button("Click me", event -> {
            Object token = VaadinSession.getCurrent().getAttribute("token");
            if (token == null) {
                Notification.show("No token found in session. Now storing token = 123456");
                VaadinSession.getCurrent().setAttribute("token", "123456");
            } else {
                Notification.show("Found token in session: " + token.toString());
            }
        });

        layout.addComponents(button);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}