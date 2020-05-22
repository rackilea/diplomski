@Controller
@RequestMapping(value="userstory/{projectid}/{sprintid}/")
@SessionAttributes(value = "user")
public class UserstoryController {
    @Autowired
    private ISprintService sprintService;

    @Autowired
    private IUserStoryService userStoryService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IBurnDownChartService burnDownChartService;

    @Autowired
    private ITaskService taskService;

    @RequestMapping(method=RequestMethod.GET)
    public String getUserstoryPage(@PathVariable("projectid") int pid, @PathVariable("sprintid") int sid,  @ModelAttribute("user") SerializablePerson user) {
        if (user.getId() != 0) {
            Project p = this.projectService.findProjectById(pid);
            if (p == null) {
                throw new ResourceNotFoundException(pid);
            }
            if (user.getRole().equals("User")) {
                return "userstory/user_userstory";
            }
            else {
                return "userstory/admin_userstory";
            }
        }
        return "redirect:../../../login";
    }
}