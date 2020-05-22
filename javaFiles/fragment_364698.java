@RequestMapping(value = "/createNewQuest",method={ RequestMethod.GET, RequestMethod.POST })
    public ModelAndView createNewQuest(@ModelAttribute("quest") Quest quest,
         BindingResult binding, ModelAndView mav, 
             final RedirectAttributes redirectAttributes) {

        questService.addQuest(quest);

        redirectAttributes.addFlashAttribute("quest", quest);
        mav.setViewName("redirect:/control/displayQuest");
        return mav;
    }