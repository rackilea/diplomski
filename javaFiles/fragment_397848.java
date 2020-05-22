@Controller
public class LoginController {
private HttpSession session=null;
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = "application/json")
public @ResponseBody Map<String, String> validateUser(@RequestBody String loginParameters,HttpServletRequest request) throws Exception {
try{
    session=request.getSession();
    JSONObject json = new JSONObject(loginParameters.trim());
    String un=json.getString("username");
    session.setAttribute("username", un);
}catch(Exception e)
{
}

}
public String getUserName()
{
return session.getAttribute("username");
}
}