@RequestMapping(value ="/grcon", method = RequestMethod.GET, params="path=register")
public String register() {
    return "registeruser";
}

@RequestMapping(value ="/grcon", method = RequestMethod.GET, params="path= usermang")
public String manageUser() {
    return "manageuser";
}

@RequestMapping(value ="/grcon", method = RequestMethod.GET)
public String index() {
    return "index";
}