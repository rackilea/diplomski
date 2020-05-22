@Controller
public class ContentItemController {

    @RequestMapping("/contentitem/{id}")
    public ModelAndView contentItem(@PathVariable("id") int id) {
        ...
    }
}