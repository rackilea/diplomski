@RequestMapping(value = "/submitUser", method=RequestMethod.POST)
public String submitUser(@ModelAttribute User userBean,Locale locale, RedirectAttributes redirectAttributes, HttpSession session, Model model) {
    boolean status = false, isAdd = false;
    String imagePath = "", task = "";
    isAdd = userBean.getAdd();
    GlobalLogger.logApplicationDebugLog("Received request to " + task + " user ", LOGGER);
    if (session != null && session.getAttribute("UserImagePath") != null) {
        imagePath = session.getAttribute("UserImagePath").toString();
    }
    int currentUserId = Integer.parseInt(session.getAttribute(SessionKeyConstants.USER_ID).toString());
    try {
        status = iuser.submitUser(userBean, imagePath,currentUserId);
        return redirectUser(userBean, locale, redirectAttributes, status,
                isAdd, task);
    } catch (UserException e) {
        GlobalLogger.logApplicationDebugLog("User Name or Employee Id exists for user "+userBean.getUserName(), LOGGER);
        redirectAttributes.addFlashAttribute("userBean", userBean);
        redirectAttributes.addFlashAttribute("errorMsg", messageSource.getMessage(e.getErrorcode(), new String[] {}, locale));
        return "redirect:/addUser.action?isAdd=true";
    }
}

private String redirectUser(User userBean, Locale locale,
        RedirectAttributes redirectAttributes, boolean status,
        boolean isAdd, String task) {
    if(isAdd) {
        if (status) {
            GlobalLogger.logInfoLog("User "+userBean.getUserName()+" has been " + task + "ed successfully", LOGGER);
            redirectAttributes.addFlashAttribute("successMsg", messageSource.getMessage("operationMsg.addUserSuccess", new String[] {userBean.getEmpEmail()}, locale));
            return "redirect:/users.action";
        } else {
            GlobalLogger.logApplicationDebugLog("Error in adding user "+userBean.getUserName(), LOGGER);
            redirectAttributes.addFlashAttribute("errorMsg", messageSource.getMessage("operationMsg.addUserFailure", new String[] {}, locale));
            redirectAttributes.addFlashAttribute("isAdd", isAdd);
            redirectAttributes.addFlashAttribute("userBean", userBean);
            return "redirect:/addUser.action?isAdd=true";
        }
    } else {
        if (status) {
            GlobalLogger.logInfoLog("User "+userBean.getUserName()+" has been " + task + "ed successfully", LOGGER);
            redirectAttributes.addFlashAttribute("successMsg", messageSource.getMessage("label.addSuccessMsg", new String[] {userBean.getFirstName()}, locale));
            return "redirect:/users.action";
        } else {
            GlobalLogger.logApplicationDebugLog("Error in adding user "+userBean.getUserName(), LOGGER);
            redirectAttributes.addFlashAttribute("errorMsg", messageSource.getMessage("label.addFailedMsg", new String[] {userBean.getFirstName()}, locale));
            redirectAttributes.addFlashAttribute("isAdd", isAdd);
            redirectAttributes.addFlashAttribute("userBean", userBean);
            return "redirect:/addUser.action?isAdd=false";
        }
    }
}