@Controller
public class MyController {
  @RequestMapping(...)
  public ModelAndView processRequest(HttpServletRequest request, 
        HttpServletResponse response) {
      Map<String, Object> model = new HashMap<String, Object>();
      Book book = ...;
      model.put("book", book);
      return new ModelAndView("viewbook", model);
  }
}