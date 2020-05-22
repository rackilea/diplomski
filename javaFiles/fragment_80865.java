@RequestMapping("/")
public class HomeController{

  @RequestMapping()
  public String showHomePage(){
     return "index";
  }
}