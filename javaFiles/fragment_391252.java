@Controller
public class StaticPagesController {
  @RequestMapping("/static/{id}/view.do")
  public String subscribersListingHandler(@PathVariable String id) {
     return id;
  }
}