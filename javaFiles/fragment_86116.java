@Controller("/users")
 public UserContoller {

  //handler methods
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(ModelMap model) {
        return "success";
  }
}