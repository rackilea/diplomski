@Controller                                                                        
public class HeyDude {                                                             

    @RequestMapping("/")                                                           
    public @ResponseBody String hello () {                                         
        return "Such cool. Many awesome.";                                         
    }                                                                              

}