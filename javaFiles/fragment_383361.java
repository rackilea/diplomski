@Controller
public class ExceptionController extends CommonController {

    @RequestMapping("/exception")
    public @ResponseBody String exception() {
        throw new VermaException();
    }

}