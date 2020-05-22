@RequestMapping(value = "/viewClient", method = RequestMethod.GET)
public ModelAndView viewClient() {
    ArrayList<SystemUser> systemUsers = clientController.getAllUsers();
    ModelAndView model = new ModelAndView("viewClient");
    model.addObject("systemUsers", systemUsers);
    return model ;
}