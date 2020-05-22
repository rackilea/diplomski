@RequestMapping(value = "/insert", method = RequestMethod.GET)
   public ModelAndView insert() {

      return new ModelAndView("script", "command" , new MyBean());
   }

   @RequestMapping(value = "/insert", method = RequestMethod.POST)
   public ModelAndView attackHandler(@ModelAttribute("myBean")MyBean mybean) {

       System.out.println(mybean.getName());

      return new ModelAndView("script", "command" , mybean);
   }