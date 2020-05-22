@RequestMapping(value = {"/delete", "/save"}, method = RequestMethod.POST)
public String crudOps(@ModelAttribute ("userForm") User user, HttpServletRequest request) {

   // find user in repository....

   if(request.getServletPath().equals("/delete"))
      delete(user);
   else
      save(user);
}