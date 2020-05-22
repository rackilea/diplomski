@Controller
publci class DemoClass implements DemoInterface{
    @Override
    public String test(@RequestBody User user) {
        /** TODO something useing the user's fileds **/
    }
}