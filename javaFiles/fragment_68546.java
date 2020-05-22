@RequestMapping("processUser")
    public String processUser(@ModelAttribute("user") User user, Model model)
    {
        Option newOption = new Option();
        model.addAttribute("user", user);
        model.addAttribute("option", newOption);
        return "process-login";
    }