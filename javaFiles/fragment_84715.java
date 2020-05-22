@RequestMapping(value="/foo", method=RequestMethod.POST)
public ModelAndView doSomething (@RequestParam Model<String, String> params) {
    params.get("val1");
    params.get("val2");
    // ...
}