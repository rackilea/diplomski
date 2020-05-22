@RequestMapping(value = "/create", method = RequestMethod.POST)
public ModelAndView create(@ModelAttribute Policy p) {
    if (p.getAdjusterId().getEntityId() == null) {
        p.setAdjusterId(null);
    }
    policyService.create(p);
    return new ModelAndView("viewName");
}