@RequestMapping(value="crime_registration_new.htm", method=RequestMethod.POST)
public ModelAndView loadNew( (...) ) throws Exception {
        // local variable - only accessible by current request
        List<Criminal> myCriminalList = new ArrayList<Criminal>();

        myCriminalList.put("dbcriminalList",
                this.citizenManager.getListOfCriminals());
        model.addAttribute("dbcriminals", myCriminalList);
        return new ModelAndView("crime_registration");
        // (...)
}