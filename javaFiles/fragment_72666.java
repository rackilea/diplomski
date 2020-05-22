@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/units")
public class UnitController {

   @RequestMapping(method = RequestMethod.GET)
   public List<Unit> method1(){..}

   @RequestMapping(method = RequestMethod.POST)
   public List<Unit> method2(){..}

   @RequestMapping(method = RequestMethod.GET, value = "/unit")
   public List<Unit> method3(){..}
}