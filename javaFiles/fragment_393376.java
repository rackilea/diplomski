@RequestMapping("/myHandler")
public ModelAndView myHandler(@ModelAttribute("myBean") MyBean myBean, BindingResults results, ModelAndView mav) {
  if (results.hasErrors()) {
    mav.setViewName("myErrorView");  // Uses the default view you have setup, passing the name as if you returned a String
  } else {
    mav.setView(new FileOutputView(dataToOutputOrWhatever);  // Custom View class to output file as needed
  }
  return mav
}