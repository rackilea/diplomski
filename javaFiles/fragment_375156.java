@Controller
    public class PageController {

        @RequestMapping(value ="/")
        public ModelAndView index() {
            ModelAndView mv = new ModelAndView("page");
            mv.addObject("message", "Hello world");
            return mv;
        }

    }