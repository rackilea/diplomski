@RequestMapping(value = "/connect", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("FlightDTO") FlightDTO flightDTO,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error.jsp";
        }
        return connect.connect(flightDTO); //passing flightDTO object received from form
    }