@RestController
public class Test{

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    String token(@RequestBody RequestBodyData requestBody) {

    return "hello" + requestBody.getUsername();
    }

}