@Controller
public class DoctorEditController {

@Autowired
    private DoctorValidator doctorValidator;

@RequestMapping(value = "/doctorEdit", method = RequestMethod.POST)
    public String processSubmit(
            @ModelAttribute("doctorForm") @Valid DoctorForm df,
            BindingResult result,
            ModelMap model) {
     ...
}
@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(doctorValidator);
    }
}