@RequestMapping(value = "/userotp", method = RequestMethod.POST)
public String validate(@ModelAttribute User user, WebRequest request, SessionStatus status) {
     // your business logic 
    status.setComplete();
    request.removeAttribute("user", WebRequest.SCOPE_SESSION);
    return "userotp";
}