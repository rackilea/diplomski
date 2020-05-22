@RequestMapping(value = "/spittles", method = GET)
public String listSpittlesForSpitter(
        @RequestParam("spitter") String username, Model model) {
    Spitter spitter = spitterService.getSpitter(username);
    model.addAttribute(spitter);
    model.addAttribute(spitterService.getSpittlesForSpitter(username));

    model.addAttribute("spittle", new Spittle()); // Add an empty model 

    return "spittles/list";
}