@ResponseBody // not needed with @RestController
@RequestMapping(value = "Test", method = RequestMethod.Get, produces = "application/json")
public String letsTest() {
    // Using Jsoniter JsonStream
    return JsonStream.serialize(myStringList);
}