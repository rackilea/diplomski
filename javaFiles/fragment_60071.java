@RequestMapping(value = "/test", method = RequestMethod.POST)
public String form(@RequestParam(required = false) Integer check) {
    if(check != null) { // if checkbox is not selected it is null
        System.out.println(check);
    }
    return "your-view";
}