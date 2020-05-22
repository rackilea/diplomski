import com.fasterxml.jackson.databind.ObjectMapper;

:

@Autowired
private ObjectMapper objectMapper;

@RestController
public class SampleController {

    @RequestMapping(value = "/jsonInfo", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public JsonNode jsonInfo()  throws JsonProcessingException, IOException {
        String string = "{\"name\": \"foo\"}"
                return objectMapper.readTree(string);
    }
}