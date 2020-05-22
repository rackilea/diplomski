import com.example.demo.domain.MyRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping(path = "/test", method = RequestMethod.POST)
    public MyRequest test(@ModelAttribute MyRequest myRequest) {
        return myRequest;
    }
}