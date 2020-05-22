@Controller
@RequestMapping(value = "/documentation")
public class ExampleDocumentationController extends ApiDocumentationController {
    public ExampleDocumentationController() {
        ...
        setBasePath("http://www.youraddress.com");
        ...
    }
}