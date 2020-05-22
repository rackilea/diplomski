@Controller
@RequestMapping("/person.html")
public class PersonsController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String initForm() {
        return "member";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute PersonView personView) {
        model.addAttribute("persons", personView);
        return "successMember";
    }

    @ModelAttribute
    public PersonView getPersonView(){
        List<Person>  persons= personService.getPersonList();
        PersonView pv = new PersonView();
        pv.setPersonList(persons);

        return pv;
    }
}