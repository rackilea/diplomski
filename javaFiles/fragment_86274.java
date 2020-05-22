@Controller
public class MapController {
    @GetMapping("map.html")
    public String get(Map<String, Object> model) throws Exception {
        MapWrapper wrapper = new MapWrapper();
        wrapper.getMap().put("1", "One");
        wrapper.getMap().put("2", "Two");
        wrapper.getMap().put("3", "Three");

        model.put("wrapper", wrapper);
        return "map";
    }

    @PostMapping("map.html")
    public String post(Map<String, Object> model, @ModelAttribute("wrapper") MapWrapper wrapper) throws Exception {
        return "map";
    }
}