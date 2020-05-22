@RequestMapping(value = "crime_registration_new.htm", method = RequestMethod.POST)
public ModelAndView loadNew( (...) ) throws Exception {
        // no need for intermediary List
        model.addAttribute("dbcriminals", this.citizenManager.getListOfCriminals());
        // (...)
        return new ModelAndView("crime_registration");
}