@RequestMapping(value = "/customlogin", method = RequestMethod.GET)
    public ModelAndView login(ModelMap mode,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        System.out.println("\n\t -------------");
        ModelAndView model = new ModelAndView("login");

        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        return model;

    }