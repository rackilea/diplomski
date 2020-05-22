import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

    @RequestMapping(path = "/")
    public String getHome(){
        return "redirect:/admin/ui/"; 
      // make sure no space between colon (:) and endpoint name (/admin/ui)
    }

    @RequestMapping(path = "/admin/ui/" )
    public  String getAdminUi(){
        return "/index.html";
      // your index.html built by angular should be in resources/static folder
      // if it is in resources/static/dist/index.html,
      // change the return statement to "/dist/index.html"
    }

}