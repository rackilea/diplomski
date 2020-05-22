@Autowired
InformationController informationController;

    @RequestMapping( ... ) // assuming you define it here
    public ModelAndView onSubmit(... ) {
      // .. code here

      if (loginsuccess) {
          InformationModel informationModelObject = informationController.handleRequest(...);
           modelAndView.addObject("informationModel", informationModelObject);
          modelAndView.setView("frontPageView");
      }
      else {
         modelAndView.setView("loginFailView");
      }

      return modelAndView;
    }