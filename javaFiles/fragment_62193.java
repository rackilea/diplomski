@RequestMapping("/people/{id}/addresses")
public class MyController {

    @RequestMapping("/{country}")
    public HttpEntity getAddress(@PathVariable String country) { ... }
}