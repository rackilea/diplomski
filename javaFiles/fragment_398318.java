@Controller
public class DurClass {

  @RequestMapping(value = "/defaultTarget", method = RequestMethod.GET)
  public String defaultTarget(Model model) {

        return "defaultTarget.html";
   }
}


<security:http auto-config="true" use-expressions="true">
    <security:form-login login-page="/login.html"
                         login-processing-url="/login_check"
                         default-target-url="/defaultTarget"
                         always-use-default-target="true"
                         authentication-failure-url="/login.html?error=true"
                         authentication-success-handler-ref="loginSuccessHandler"/>