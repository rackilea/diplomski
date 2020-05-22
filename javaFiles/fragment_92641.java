@ControllerAdvice(assignableTypes = SettingsController.class)
public class SettingsControllerAdvice {

    @ModelAttribute("classActiveSettings")
    public String cssActivePage() {
        return "active";
    }

}