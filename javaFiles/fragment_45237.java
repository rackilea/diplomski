@Controller
public class MyController {
    @GetMapping("/withView")       // results in {"ssn":"123-45-6789"}
    @JsonView(Views.ShowSSN.class)
    public @ResponseBody MyBean withJsonView() {
        return new MyBean("123-45-6789");
    }

    @GetMapping("/withoutView")    // results in {"ssn":"xxx-xx-xxxx"}
    public @ResponseBody MyBean withoutJsonView() {
        return new MyBean("123-45-6789");
    }

}