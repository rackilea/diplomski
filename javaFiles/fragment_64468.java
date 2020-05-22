@RequestMapping(value = "/someUrl")
public firstReturnType someMethod(@RequestParam("param") int param ) {
    if(param == 1){
        ...
    }
    else if(param == 2){
        ...
    }
}