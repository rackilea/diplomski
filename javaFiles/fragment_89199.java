@RequestMapping(value = "/owners", method = RequestMethod.GET)
public String processFindForm(Owner owner, BindingResult result, Map<String, Object> model)
{

    String ownerId = DEFAULT value;
}

@RequestMapping(value = "/owners/{ownerID}", method = RequestMethod.GET)
public String processFindForm(@RequestParam("ownerID") String ownerId, Owner owner, BindingResult result, Map<String, Object> model)
{

}