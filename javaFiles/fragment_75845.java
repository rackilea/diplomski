@RequestMapping(value = "user/calculate", method = RequestMethod.GET)
public ModelAndView comparison(@ModelAttribute("myInfo") YourInfo yourInfo) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("firstClient", yourInfo.getFirstInfo());
    modelAndView.addObject("secondClient", yourInfo.getSecondInfo());
    return modelAndView;
}