@Controller
@RequestMapping("/person")
public class PersonController {



@RequestMapping(value ="/edit", method=RequestMethod.GET)
public String edit(Person person, BindingResult result){

    return "person/edit";       
}

@RequestMapping(value ="/edit", method=RequestMethod.POST)
public String submit(Person person, BindingResult result){
    if(result.hasErrors()){
        return "person/edit";   
    } else {
        return "redirect:person/edit.ss";
    }
}