@RequestMapping(value="/saveReferral", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("saveReferral") Referrals referral){
        ModelAndView model=new ModelAndView("referralPage");     
        model.addAttribute("categoryOptions",new Referrals());   //or referral
        return model;
    }