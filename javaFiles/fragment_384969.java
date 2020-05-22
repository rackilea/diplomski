@RequestMapping(value ="/grcon", method = RequestMethod.GET)
public String register(@RequestParam(value="path", required=false) String path) {
    if ("register".equals(path) ) {
        return "registeruser";
    } else if ("usermang".equals(path)) {
        return "manageuser";
    }
    return "index";
}