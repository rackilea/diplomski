@RequestMapping(value = "/user/calculate", method = RequestMethod.POST )
public String compareClients(@Valid UserInfo calculate, BindingResult bindingResult, Model model) {

   /*some calculations*/
    long firstClient=calculate.getFirstId();
    long secondClient=calculate.getSecondId();
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.addObject("firstInfo",firstClient);
    modelAndView.addObject("secondInfo",secondClient);
    modelAndView.addObject("infoId",id);
    if(!model.containsAttribute("myInfo")){
        YourInfo yourInfo = new YourInfo();
        yourInfo.setFirstInfo(String.valueOf(firstClient));
        yourInfo.setSecondInfo(String.valueOf(secondClient));
        model.addAttribute("myInfo",yourInfo);
    }

    return "redirect:/user/calculate";
}