@RequestMapping(value = "/Home", method = RequestMethod.GET)
    public String home(@ModelAttribute("user") User user, Model model) {
        logger.debug("BEGIN");
        /*
        .
        .
        .
        */
        logger.debug("END");
        model.addAttribute("currPage", "liHome");
        return "Home";
    }