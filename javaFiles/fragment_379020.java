@Controller
@RequestMapping({ "/home", "/users" })


    @RequestMapping("/method1")
    public void method1(){
    ...
    }

   @RequestMapping(method="RequestMethod.GET")
    public void listUsers(){
    ...
    }