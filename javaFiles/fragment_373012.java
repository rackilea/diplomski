@RequestMapping(method = RequestMethod.GET)
public String getForm() {

    model.addAttribute("message", "Hello Mahdi");
    return "hello"; // assume hello.jsp
}

@RequestMapping(params={"submit"}, method = RequestMethod.GET)
public String printWelcome(ModelMap model, @RequestParam(value = "xx",required=true) String xx) {

    /*
     Do something with submitted parameter
     and return some view name
    */
}