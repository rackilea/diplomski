@RequestMapping(value = "index", method = RequestMethod.GET)
@ResponseBody
public HashMap<String, String> handleRequest() {
    HashMap<String, String> model = new HashMap<String, String>();
    String name = "Hello World";
    model.put("greeting", name);

    return model;
}