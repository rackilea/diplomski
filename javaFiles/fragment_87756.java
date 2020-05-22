@Controller
public class PersonController {

    @RequestMapping("person/{id}")
    @ResponseBody
    public Person getById(@PathVariable String id) {
        if ("007".equals(id)) {
            throw new RuntimeException("007 is a secret agent.");
        }
        return personService.getById(id);
    }

    @ExceptionHandler(RuntimeException.class) // this can be an array
    @ResponseBody
    public String handleRuntimeException(RuntimeException ex,
                                         HttpServletRequest request) {
        return "Oops! Something bad happened: "+ex.getMessage();
    }
}