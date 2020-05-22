@RequestMapping(value="edit", method=RequestMethod.POST)
public ModelAndView acceptEdit(@ModelAttribute ArticleFormModel model, 
    BindingResult errors, HttpServletRequest request)
{
  if (errors.hasErrors()) {
    // error handling code goes here.
  }
  ...
}