@RestController
@RequestMapping("/resource")
public class MyController {

    @Autowired
    private ResourcesBl resourcesBl;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Resource create(@RequestBody Resource resource) {
        return resourcesBl.create(resource);
    }

    @RequestMapping(value = "/{resourceName}", method = RequestMethod.POST)
    @ResponseBody
    public OtherResource create(@PathVariable String resourceName,
                                @RequestBody OtherResource otherResource) {
        return resourcesBl.createOther(resourceName, otherResource);
    }
}