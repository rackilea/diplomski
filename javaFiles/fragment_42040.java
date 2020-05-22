@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false)){
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
          modelAndView.setViewName("error page");
        } else modelAndView.setViewName("login");

        return modelAndView;
    }