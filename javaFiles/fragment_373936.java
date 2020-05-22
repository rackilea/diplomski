@RestController
@ConditionalOnExpression("${my.controller.enabled:false}")
@RequestMapping(value = "foo", produces = "application/json;charset=UTF-8")
public class MyController {
    @RequestMapping(value = "bar")
    public ResponseEntity<String> bar(
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }
}