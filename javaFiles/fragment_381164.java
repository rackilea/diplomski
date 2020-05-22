@RequestMapping(value = "/p/ajax/mytest", method = RequestMethod.POST)
public @ResponseBody String myTest(@RequestParam Long anId) throws JSONException {
    JSONObject result = new JSONObject();
    result.put("status", "success");
    result.put("value4", "success");    
    result.put("username", "success");
    result.put("myanId", anId);

    return result.toString();
}