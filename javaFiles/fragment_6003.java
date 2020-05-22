/*
 * Update a survey request
 */
@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
public String update(@ModelAttribute("surveyRequest") SurveyRequest surveyRequest,
                     BindingResult bindingResult, Model uiModel,
                     HttpServletRequest httpServletRequest,
                     RedirectAttributes redirectAttributes, Locale locale) {
  [...]
}