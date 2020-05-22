@Controller
@RequestMapping("/product")
public class ProductController{

    @RequestMapping("/index")
    public String index() {
        return "welcome";
    }

    @RequestMapping("/getProducts")
    public String getProducts() {
        //your business logic
        return "getProducts";
    }
}