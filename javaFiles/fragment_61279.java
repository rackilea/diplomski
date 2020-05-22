GET http://localhost:8080/public/test/1,2,3,4

@RequestMapping(value="/test/{firstNameIds}", method=RequestMethod.GET)
@ResponseBody
public String test(@PathVariable String[] firstNameIds)
{
    // firstNameIds: [1,2,3,4]
    return "Dummy"; 
}