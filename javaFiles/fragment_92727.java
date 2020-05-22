@Controller
public class EmployeeController {

private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

private Map<Integer, Employee> emps = null;

public EmployeeController() {
    emps = new HashMap<Integer, Employee>();
}

@RequestMapping(value = "/emp/save.do", method = RequestMethod.POST)
public String saveEmployeeAction(@Valid Employee employee, BindingResult bindingResult, Model model) 
  {
    if (bindingResult.hasErrors()) {
        logger.info("Returning empSave.jsp page");
        return "empSave";
    }
    logger.info("Returning empSaveSuccess.jsp page");
    model.addAttribute("emp", employee);
    emps.put(employee.getId(), employee);
    return "empSaveSuccess";
  }
}