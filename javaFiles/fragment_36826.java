package some.pkg.of.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ControllerSetup {

    @ModelAttribute
    public void initModel(HttpServletRequest request, Model model) {
        model.addAttribute("_csrf", request.getAttribute("_csrf"));
    }

}