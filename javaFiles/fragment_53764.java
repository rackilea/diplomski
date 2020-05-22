@RequestMapping(value = "proffessional", method = RequestMethod.POST)
    public @ResponseBody
    String proffessionalDetails(
            @ModelAttribute UserProfessionalForm professionalForm,
            BindingResult result, Model model) {

        UserProfileVO userProfileVO = new UserProfileVO();

        userProfileVO.setUser(sessionData.getUser());
        userService.saveUserProfile(userProfileVO);
        model.addAttribute("PROFESSIONAL", professionalForm);

        return "Your Professional Details Updated";

    }