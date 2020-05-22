@RequestMapping(value = "/submitrule", method = RequestMethod.GET)
      public ModelAndView addruleSerch() {
     ModelAndView model = new ModelAndView("yourView");
     //here you choose the name you will use in your view, is up to you the name to choose
     model.addObject("formRule", new FormRule()); 
     return model;
}