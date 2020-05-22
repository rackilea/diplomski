@Controller
 public class SomeController {

     @RequestMapping("/somepage.jsp ") 
     public String somePage(HttpServletRequest request, ModelMap model) {
         List<Address> addresses = ....
         // We can now access the key "addresses" in our jsp
         model.put("addresses", addresses);
         return "/WEB-INF/jsp/somepage.jsp";
     }
 }