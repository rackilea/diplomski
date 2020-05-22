@RequestMapping(value ="/register" ,method = RequestMethod.GET)
    public ModelAndView getRegister()
    {

        ModelAndView modelregister = new ModelAndView();

        modelregister.setViewName("registeruser");
        modelregister.addObject("Registration", "info");

        return modelregister;

    }

    @RequestMapping(value ="/manageuser" ,method = RequestMethod.GET)
    public ModelAndView getManageUser()
    {

        ModelAndView modelManageUser = new ModelAndView();

        modelManageUser.setViewName("manageuser");
        modelManageUser.addObject("User Records", "records");

        return modelManageUser;

    }