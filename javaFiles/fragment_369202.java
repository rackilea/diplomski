@RestController
public class MyController {
    @GetMapping(value = /{id})
    public String get(@PathVariable String id) {
        ...
    }

    @PostMapping(value = "/{id}")
    public String post(@PathVariable String id, Payload payload) {
        ...
    }

    @GetMapping("/deeper/{id}")
    public String getDeeper(@PathVariable String id) {
       ....
    }
    }