@Controller
@RequestMapping("/form")
@SessionAttributes({"formBean"})
public class FormController {
    @RequestMapping()
    public String defaultView(@ModelAttribute("formBean") FormBean formBean, Model uiModel) {
        // Do something...add anything to the uiModel that you want to use in your form...you should not need to add formBean as it should auto-matically get put into session now with the @SessionAttributes annotation
        // Also to note, if you set the "formBean" attribute on the Model or ModelAndView, it will replace the one in Session.  Also, you can add the SessionStatus to one of your methods and use its .setComplete() method to indicate you are done with the session...you usually do this after you know the user is done with the application so the session can get cleaned up.
    }

    @RequestMapping("/someOtherPath")
    public String someOtherHandler(@ModelAttribute("formBean") FormBean formBean, Model uiModel) {
        // Do something...again, formBean should be either created or out of session
    }

    @ModelAttribute("formBean")
    private FormBean createFormBean() {
        // This method can be named anything, as long as it returns a FormBean, has the @ModelAttribute named on it, and has no arguments.  Use this method to populate your FormBean when its created (set defaults and such).
        return new FormBean();
    }
}