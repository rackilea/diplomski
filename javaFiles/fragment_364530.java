@RequestMapping(value="/security_param", method=RequestMethod.GET)
public @ResponseBody Map<String,Object> getSecurityParam(){
    Map<String,Object> m = new LinkedHashMap<String,Object>();
    m.put("token", result.getBigInteger().toString());
    return m;
}