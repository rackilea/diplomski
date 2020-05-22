@RequestMapping(value = "/user-search", method = RequestMethod.GET)
    public String initUserSearchForm(Model model) {
        User user = new User();
        model.addAttribute("User", user);
        if(!model.containsAttribute("userObject"))
           model.addAttribute('userObject',createDefaultUserCredntials());
        return "user";
    }