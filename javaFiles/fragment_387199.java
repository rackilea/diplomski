@Controller
@RequestMapping("/edit/{id}")
@SessionAttributes("student")
public EditStudentController

    @Autowired  
    private StudentFormValidator validator;

    @Autowired
    private StudentRepository studentRep;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(method=RequestMethod.GET)
    public String showUpdateForm(Model model) {
        model.addObject("student", studentRep.secureFind(id));
        return "students/form";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String public String updateFromForm(@Valid @ModelAttribute Student student, BindingResult result, RedirectAttributes redirectAttributes, SessionStatus status)   {  
        // Optionally you could check the ids if they are the same.
        if (result.hasErrors()) {  
            return "students/form";
        } 
        redirectAttributes.addFlashAttribute("message", "?p?t???? p??s????!");
        studentRep.save(student);
        status.setComplete(); // Will remove the student from the session
        return "redirect:/students/list";  
    }
}