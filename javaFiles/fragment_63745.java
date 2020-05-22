@RestController
public class Controller {

    @Value("${url}")
    String url;

    @RequestMapping("/path"
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Location> locations(@RequestParam String query) {

        // RestTemplate will make the service call and handle the 
        // mapping from JSON to Java object

        RestTemplate restTemplate = new RestTemplate();
        ThirdPartyResponse response = restTemplate.getForObject(url, ThirdPartyResponse.class);

        List<Location> myResponse = new List<>();            

        // ... do whatever processing you need here ...

        // this response will be serialized as JSON "automatically"
        return myResponse;
    }
}