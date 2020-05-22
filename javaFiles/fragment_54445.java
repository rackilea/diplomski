...
public class ProjectController {

    @Autowired
    ProjectValidator projectValidator;

    ...

    @RequestMapping(...)
    public String yourCreateMethod(..., @ModelAttribute @Valid Project project, BindingResult result) {
        projectValidator.validate(project, result);           

        if (result.hasErrors()){
          // do something
        }
        else {
          // do something else
        }
    }

}