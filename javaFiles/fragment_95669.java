@GetMapping("action")
public String method(@PathVariable Long id){

    Entity e = entityService.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("redirect:/entity/list"));

    // other actions that are using e

    return "view-name";
}