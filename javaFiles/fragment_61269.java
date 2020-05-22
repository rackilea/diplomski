@RestController
@RequestMapping(value = "/json")
@Validated
public class JsonResource {

    @RequestMapping(method = POST, consumes=APPLICATION_JSON_VALUE"))
    public void postJson(@SafeHtml @RequestBody JsonNode jsonQuery){
        // post a foo
    }

}