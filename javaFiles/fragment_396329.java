@RequestMapping(value = "users/edit/{userId}", method = RequestMethod.GET)
public ModelAndView getClientStat(@PathVariable(value="userId", required = true) String userId) {

    //Use the userId to find user information and pass
    modelAndView.addAttribute("id", userId)
    modelAndView.setViewName("users/edit");
    return modelAndView;
}