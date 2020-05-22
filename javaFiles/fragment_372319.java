@Controller
@RequestMapping("/foo")
public class Foo {

    private User theUser; // problem is ALL request share this field

    @RequestMapping("/foo/{userId}")
    public String foo(@PathVariable final Integer userId) {
       if (theUser.getId().equals(userId)) {
           // something
       } else {
           theUser = ...
       }
       return "view"
    }
}