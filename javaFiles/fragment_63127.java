@Controller
public class HelloController{

   @RequestMapping("/getCitiesForState")
   @ResponseBody
   public List<City> printHello(@RequestParam long state) {
      List<City> cities = //get from the some repository by state
      return cities;
   }

}

public class City{
   private String value;
   private String text;
   //getters setters
}