@RequestMapping(value="/test")
    public ModelAndView processSubmit(@RequestBody MyClassTesttest) {
        ModelAndView mv = new ModelAndView("response");
        System.out.println("Test was fine");
        return mv;
    }