@RestController
public class IndexController {

    @Autowired
    MessageService messageService;

    @RequestMapping("/")
    String getMessage() {
        return messageService.getMessage();
    }
}