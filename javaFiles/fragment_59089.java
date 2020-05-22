@Controller
  public class AuthenticateController{
     @RequestMapping(value="authenticate",method = RequestMethod.POST,consumes="application/json",produces="application/json")
     @ResponseBody
     public String authenticateUser((@RequestBody String json){
        //Now by using json data you can verify user by querying DB,and return your own message.
     }
  }