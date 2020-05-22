@RequestMapping("/")
public String showForm(Model m)
{
     m.addAttribute("command", new Student());  
     return "studentform";

}