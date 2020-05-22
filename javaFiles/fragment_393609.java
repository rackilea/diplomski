@RestController
public class OwnerController {

    @GetMapping(value = "owner/{ownerId}/animal")
    public List<Animal> getAnimalsForOwner(@PathVariable("ownerId") Long id) {

    }

}