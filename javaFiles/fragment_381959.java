RequestMapping("SOME_VALUE")
public Object NAME_OF_FUNCTION (PARAMS){
    if (something) {
        return "a string";
    } else if (somethingElse) {
        return new ResponseEntity(new byte[] {1,2,3});
    } else 
        return new OtherType();
}