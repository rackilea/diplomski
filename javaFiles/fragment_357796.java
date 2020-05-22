import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class RedirectModel {
    @Pattern(regexp="^/([^/].*)?$")
    @NotBlank
    private String continueUrl;

    public void setContinue(String continueUrl) {
        this.continueUrl = continueUrl;
    }

    public String getContinue() {
        return continueUrl;
    }
}

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(Principal principal, @Valid @ModelAttribute RedirectModel model, BindingResult result) {
        if (!result.hasErrors() && principal != null) {
            // do not redirect for absolute URLs (i.e. https://evil.com)
            // do not redirect if we are not authenticated
            return "redirect:" + model.getContinue();
        }
        return "login";
    }
}