@Controller
public class MyController {

    ...

    @RequestMapping(...)
    public void createMyObject(...) throws MyAppTechnicalException {
        ...
        someServiceThanCanThrowMyAppTechnicalException.create(...);
        ...
    }

    ...

    @ExceptionHandler(MyAppTechnicalException.class)
    public String handleMyAppTechnicalException(MyAppTechnicalException e, Model model) {

        // Compute your generic error message/code with e.
        // Or just use a generic error/code, in which case you can remove e from the parameters
        String genericErrorMessage = "Some technical exception has occured blah blah blah" ;

        // There are many other ways to pass an error to the view, but you get the idea
        model.addAttribute("myErrors", genericErrorMessage);

        return "myView";
    }

}