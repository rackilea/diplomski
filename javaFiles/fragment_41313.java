@ControllerAdvice
public class LayoutMenu {
    @ModelAttribute("foo")
    public String initMenu() {
        return "Hello Bar";
    }
}