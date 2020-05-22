@Controller
public class SomeController {
    @Autowired private Validator validator;

    @RequestMapping(...)
    public ResponseEntity<?> someHandler(@RequestBody SomeBody body) {
        Set<ConstraintViolation<SomeBody>> violations = validator.validate(body);
        if (!violations.isEmpty()) {
            List<String> messages = violations
                                   .stream()
                                   .map(ConstraintViolation::getMessage)
                                   .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(messages);
        }
        // the rest of controller
    }
}