@RequestMapping("/people")
class PersonController {

    @RequestMapping("/{id}")
    public HttpEntity<Void> getPerson(@PathVariable String id) { ... }

}