@RepositoryRestController
public class CustomRepositoryRestController {
    @RequestMapping(path = "/repositoryRestControllerTest", method = RequestMethod.GET)
    @ResponseBody
    public String nameOne() {
        return "test";
    }

}