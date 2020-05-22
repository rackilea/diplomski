@RequestMapping(value = "login.html", method = RequestMethod.POST)
    public ModelAndView post(@ModelAttribute("login") LoginEntity login, HttpServletRequest req) {


... process the data ...
if passed put it into session:

HttpSession session = req.getSession(true);
UserObject userObject=new UserObject();
userObject.setName(login.getUserName());
...

session.setAttribute("user",userObject);