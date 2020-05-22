@RestController
class ContainerController {

    @Value("${endpointUrl}")
    private String ednpointUrl;

    @RequestMapping("/container/{cid}")
    public list(@PathVariable Integer cid) {
        def template = new RestTemplate();
        def container = template.getForObject(endpointUrl+"/container/" + cid.toString(), Container);
        return container;
    }
}