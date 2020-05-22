@Controller
@SessionAttributes("todos")
public class FooController { 

  @GetMapping("/todos.html")
  public String list(@ModelAttribute TodoList todos) {
    // set the todos value
    return "scopedproxytodos";
  }

}