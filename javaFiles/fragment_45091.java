public class MyController {
    @RequestMapping("/foo/bar") 
    public String MyAction() { return someSharedFunc(false); }

    @RequestMapping("/debug/ping");
    public String MyDebugPing() { return someSharedFunc(true); }

    private String someSharedFunc(boolean debug) {
      if(debug) return "FooBar"; else return "Debug!";
    }
}