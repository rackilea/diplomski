@RestController
public class MyController {
    @RequestMapping(value="/getMapResult")
    public @ResponseBody
    Map<String,List<?>> getMapResult() {
        Map<String,List<?>> result = new HashMap<>();
        result.put("a", Arrays.asList("a1","a2"));
        result.put("b",Arrays.asList(1,2,3));
        return result;
    }
}