@Controller
public class Controller
{
    @RequestMapping(value = "/offers/{id}")
    public String offer(@PathVariable String id, final Model model)
    {
        //pass the value from the url to your jsp-view, access it via ${id} from 
        //there
        model.add("id",id);  
        //render the page "empressa.jsp"
        return "empressa";
    }
}