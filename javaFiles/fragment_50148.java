EX 
JavaScript OBJ
var arr = ["1", "2", "3"];
$http.post('someUrl', arr)...

Java
@RequestMapping(value = {"/someUrl"}, method={RequestMethod.POST})
public void foo(String s) { // s will be = "1,2,3"

}