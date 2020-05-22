@RestController
public class PetController {

    @GetMapping(value = "/internal")
    public void invokeInternal(@ModelAttribute Pet pet) {
        System.out.println(pet);
    }

    @PostMapping(value = "/owners/{ownerId}/pets/{petId}/edit")
    public RedirectView editPet(@ModelAttribute Pet pet, RedirectAttributes attributes) {
        System.out.println(pet);
        pet.setHiddenField("XXX");

        attributes.addFlashAttribute("pet", pet);
        return new RedirectView("/internal");
    }

}