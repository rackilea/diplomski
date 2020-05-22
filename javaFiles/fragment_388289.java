@RestController
@RequestMapping("/somewhere")
public class CustomInterfaceController {
    @RequestMapping
    public ResponseEntity doSomething(CustomInterface ci, ...) {
        ....
    }
}