@Controller
@RequestMapping("/p/{abbr}/scope")
public class ScopeController {

    private static final String SHOW_PROJECT_PAGE = "/projects/scope/show";

    private static final Logger log = LoggerFactory.getLogger(ScopeController.class);

    @Autowired
    private ProjectService projectService;

    // method is called before show() and update()
    @ModelAttribute
    private void initProject(@PathVariable(value = "abbr") String abbr, Model model) {
        log.debug("loading project for '{}'", abbr);
        // load the project JPA entity from the database, will be merged with the  
        // updated form values in the POST request. By doing this, I can asure
        // that the primary key (the ID) and the related objects are present as 
        // needed for the em.saveOrUpdate() in the projectService.save() method.
        model.addAttribute("project", projectService.find(abbr));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show() throws BindException {
        // shows the project scope form with the project 
        // added in 'initProject()'
        return SHOW_PROJECT_PAGE;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String update(
            // the project with the updated form values and the JPA ID and JPA 
            // relations as loaded in the initProject()
            @Valid @ModelAttribute Project project, BindingResult result, 
            RedirectAttributes redirectAttrs)
            throws MethodArgumentNotValidException {

        redirectAttrs.addFlashAttribute(project);

        try {
            if (!result.hasErrors()) {
                projectService.save(project);
            }
        }
        catch (Exception e) {
            log.error(e.toString());
            throw new MethodArgumentNotValidException(null, result);
        }

        log.debug("project '{}' updated", project.getAbbreviation());
        return SHOW_PROJECT_PAGE;
    }
}