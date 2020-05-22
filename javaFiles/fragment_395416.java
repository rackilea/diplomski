@RequestMapping(value = "/restcall", method = RequestMethod.POST, produces = "application/json")
public @ResponseBody Object restCall(@RequestBody(required = true) PojoJSONDescriptor desc) throws IOException {
    PojoResponseJSONDescriptor res = new PojoResponseJSONDescriptor();
    res.setName("Test");
    return res;
}