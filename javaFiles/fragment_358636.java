@Controller
@RequestMapping(value="/login")
public class LoginFormController {  

@RequestMapping(method=RequestMethod.POST)
public ModelAndView post(@ModelAttribute User user, BindingResult result,
      SessionStatus status, final RedirectAttributes redirectAttrs) {

    logger.info("post");
    new ReceiptUserValidator().validate(user, result);
    if (result.hasErrors()) {
        return new ModelAndView("login");
    }
    else {
        logger.info("Email Id: " + user.getEmailId());
        //status.setComplete();         

        redirectAttrs.addFlashAttribute("userId", user.getEmailId());
        redirectAttrs.addFlashAttribute("now", new Date().toString());

        return new ModelAndView("redirect:/landing.htm", "model", model);
    }
}