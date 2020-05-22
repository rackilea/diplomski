@RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String updateView(UserForm userForm,
                               HttpSession session,
                               ModelMap model) {

        User user = (User) session.getAttribute("user");
        userForm.setUser(user);
        model.addAttribute("userForm", userForm);
        return "profileupdate";
    }


    @RequestMapping(value = "/edit.do", method = RequestMethod.POST)
    public String updateUserProcess(@ModelAttribute(value = "userForm")
                                    UserForm userForm,
                                    BindingResult result, Model model,
                                    HttpSession session) {
        User user = (User) session.getAttribute("user");
        session.getAttribute("userForm");
        model.addAttribute("userForm", userForm);
        userValidator.validate(userForm, result);
        if (result.hasErrors()) {
            logger.error("Validation error");
            return "profileupdate";
        }
        if (!updatingUser(userForm, model, user)) {     
            logger.error("User update error!");
            logger.error("Login or Email is already in use!");
            model.addAttribute("errorMsg", "Login or Email is already in use!");
            return "profileupdate";
        }
        logger.info("User updated!");
        return "newuserprofile";
    }