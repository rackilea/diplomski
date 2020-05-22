public class MainController extends MultiActionController {
    public ModelAndView logincontrol(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("Add method called");
        return new ModelAndView("LoginPage", "POJO", new LoginPojo());
    }
    //...
}