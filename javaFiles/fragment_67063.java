@RequestMapping(value = "/getjson", method = RequestMethod.GET, produces="application/json")
@ResponseBody
public String getJson() {
   //your logic
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(json);
}

@RequestMapping(value = "/post", method = RequestMethod.POST, produces="application/json", consumes="application/json")
@ResponseBody
public String post(@RequestBody String json) {
    POJO pj = new POJO();
    ObjectMapper mapper = new ObjectMapper();
    pj = mapper.readValue(json, POJO.class);

    //do some things with json, put some header information in json
    return mapper.writeValueAsString(pj);
}