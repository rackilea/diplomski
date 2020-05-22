@RestController
@RequestMapping(value = "/endPoint", method = RequestMethod.POST)
public MyObject anyMethodName(@RequestBody  MyObject myObject) {
     //Do stuff to myObject
     return myObject;
}