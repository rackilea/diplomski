@Controller
public class CommonController {

    @ExceptionHandler
    public @ResponseBody String handle(VermaException e) {
        return "error";
    }
}