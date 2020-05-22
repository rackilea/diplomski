@RestController
public class TestServlet {
    @PostMapping(value = "/test", consumes = APPLICATION_JSON_VALUE)
    public String test(@Valid @NotBlank @RequestBody Map<String, String> body) {
        return body.get("test");
    }
}