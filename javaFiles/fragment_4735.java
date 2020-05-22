@RequestMapping(value = "/loggedUsers", method = RequestMethod.GET)
  @ResponseBody
  public String getLoggedUsers(Model model) {
  model.addAttribute("loggedUsers", activeUsers.getUsers());
  return "loggedUsers";
}