@RequestMapping(value = "/viewClient", method = RequestMethod.GET)
public String viewClient(ModelMap model) {
    ArrayList<SystemUser> systemUsers = clientController.getAllUsers();
    model.addAttribute("systemUsers", systemUsers);
    return "viewClient";
}