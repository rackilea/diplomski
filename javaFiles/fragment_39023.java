@RequestMapping("/to-be-redirected")
public RedirectView localRedirect() {
    RedirectView redirectView = new RedirectView();
    redirectView.setUrl("http://www.yahoo.com");
    return redirectView;
}