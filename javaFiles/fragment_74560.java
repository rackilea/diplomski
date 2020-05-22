@RestController
@Api(tags = { "test" }, description = "test related resources")
public class TestController {

    @Autowired
    ObjectMapper mapper;

    @ApiImplicitParams({
        @ApiImplicitParam(name = "requestBody", required = true,
            dataType = "TestDTO", paramType = "body")
    })
    @RequestMapping(path = "/test", method = RequestMethod.POST)
    public void confirm(@RequestBody String requestBody) throws IOException {

        //do sth with body

        TestDTO dto = mapper.readValue(requestBody, TestDTO.class);

        //do sth with dto
    }
}