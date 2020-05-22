@RequestMapping(value="citizen_list.htm", method = RequestMethod.POST)
public ModelAndView getCitizenList(@Valid @ModelAttribute Citizens citizen, BindingResult result, ModelMap m, Model model, @RequestParam(value="user_request") String user_request) throws Exception {

   try{
        logger.debug("about to preform query");
        //citizenManager.getListOfCitizens(citizen);
        if(citizenManager.getListOfCitizens(citizen).isEmpty()){
             model.addAttribute("icon","ui-icon ui-icon-circle-close");
             model.addAttribute("results","Notice: Query Caused No Records To Be Retrived!");                            
        }else{
             model.addAttribute("citizens",citizenManager.getListOfCitizens(citizen));
             return new ModelAndView("citizenList"); 
        } 
    }catch(Exception e){
        logger.error("Exception in CitizenRegistrationController - ModelAndView loadPage "+e);
        //request.setAttribute("error",e.getMessage());
         return new ModelAndView("citizen_registration");
    }
}

@RequestMapping(value="citizen_registration.htm", method = RequestMethod.POST)
public ModelAndView handleRequest(@Valid @ModelAttribute Citizens citizen,  BindingResult result, ModelMap m, Model model, @RequestParam(value="user_request") String user_request) throws Exception {

    try{
         logger.debug("In Http method for CitizenRegistrationController - Punishment Registration");
         logger.debug("User Request Is " + user_request);

         if(result.hasErrors()){
            logger.debug("Has Errors");
            return new ModelAndView("citizen_registration");
         }else{
             //check if its a save of an update
             if(user_request.equals("Save")){
                 citizenManager.RegisterCitizen(citizen);   
                 model.addAttribute("icon","ui-icon ui-icon-circle-check");
                 model.addAttribute("results","Record Was Saved");
                 return new ModelAndView("citizen_registration");
             } else if (user_request.equals("Update")){
                 logger.info("About to do update");
                 citizenManager.UpdateCitizen(citizen);
                 return new ModelAndView("citizen_registration");                        
             }                  
         }

        logger.debug("Has No Errors");     
        return new ModelAndView("citizen_registration");

    }catch(Exception e){
        logger.error("Exception in CitizenRegistrationController - ModelAndView loadPage "+e);
        //request.setAttribute("error",e.getMessage());
         return new ModelAndView("citizen_registration");
    }
}