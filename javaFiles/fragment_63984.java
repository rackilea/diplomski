@RequestMapping( value="/info", method = RequestMethod.POST)
public ResponseEntity<String> receiveBody(@RequestParam("name") String name, @RequestParam("place") String place, @RequestParam("age") int age)
{
    //you can do something with variables age, name and place here
    ....
    return new ResponseEntity<String> ("someResponse", headers, HttpStatus.OK);
}