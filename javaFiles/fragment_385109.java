@RequestMapping("/")
public String home() {
    return "redirect:/index";
}

@RequestMapping(value = "/index", method = RequestMethod.GET)
public String createRegisterForm(Map<String, Object> model){
    model.put("userprofile", new UserProfile());
    return "index";
}