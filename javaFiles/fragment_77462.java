public class MyVaadinUI extends UI {

    protected void init(VaadinRequest request) {
        System.out.println("Location scheme=[" + Page.getCurrent().getLocation().getScheme() + "]");
        System.out.println("Web browser isSecureConnection=[" + Page.getCurrent().getWebBrowser().isSecureConnection() + "]");
        System.out.println("Request isSecure=[" + request.isSecure()+"]");
    }
}