private User userAccount;

@RequestMapping(method = RequestMethod.GET)
public String getSuccess(ModelMap model, @ModelAttribute("user") User user, HttpServletRequest request)
{
    String boxDisplay = "True"; 
    user.setdisplayBox(boxDisplay);
    userAccount = user; //load user in to global var 
    return "success";
}

@RequestMapping(method = RequestMethod.POST)
public String resetPassword(HttpServletRequest request, ModelMap model, @ModelAttribute("user") User user, ModelMap modelMap) 
{
    user.setdisplayBox(userAccount.getdisplayBox()); 
    userAccount = null; //reset it to something to make sure you are loading it to another user later.
    return "success";
}