@Controller
    public class MyController{

        //spring will automatically bind value of property
        @Value("${my.property}")
        private String myProperty;

        @RequestMapping("/mapping")
        public String controllerMethod(){
             ...
        }
    }