import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DemoController {

  @RequestMapping("/api/propertyReports/search/removeByUse‌​rId/{userId}")
  public String hello(@PathVariable(value = "userId") final Long userId){

//add method call here to delete your data that you want
    return "Hello World";
  }
}