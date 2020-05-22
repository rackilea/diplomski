@Controller
@RequestMapping("/employee")
public class Employee {

  @RequestMapping(value="", method=RequestMethod.GET)
  public String disp(HttpServletRequest request, @RequestParam(value="ename", required=false) String ename) {
    // used
    System.out.println(ename); // voted
    // or
    request.getParameter("ename");
  }
}