import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RequestMapping(method = RequestMethod.POST, produces = "application/json")
public @ResponseBody String getMethod(@RequestHeader(value="json") String headerStr) {
    System.out.println("POST");
    System.out.println(s);
    return "hello";
}