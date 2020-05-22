@RequestMapping("/users")
@Controller
public class UsersController {

            @Autowired
            private MessageSource messageSource;

            @RequestMapping(method = RequestMethod.POST, produces = "text/html")
            public String create(@Valid User user, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest, Locale locale, RedirectAttributes redirectAttributes) {
                ...
                ...
                redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", messageSource.getMessage("label_user_saved_successfully", new String[] {user.getUserId()}, locale));
                return "redirect:/users/" + encodeUrlPathSegment("" + user.getId(), httpServletRequest);
            }
    ...
    ...
}