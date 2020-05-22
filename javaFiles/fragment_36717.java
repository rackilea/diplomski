public ModelAndView testRoCompliance(@RequestParam String regOfficeStr) {
    Map<String, Object> results = new HashMap<>();
    results.put("inputs", "an input");
    results.put("result", "the answer");
    ModelAndView modelAndView = new ModelAndView("simpleOutput");
    modelAndView.addObject("results", results);
    return modelAndView;  
 }