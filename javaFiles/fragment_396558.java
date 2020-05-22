@RequestMapping
public String view(RenderRequest request, Model model){
    PortletSession session = request.getPortletSession();
    if (session.getAttribute("foo", 
            PortletSession.APPLICATION_SCOPE) != null) {
        model.addAttribute("foo", session.getAttribute("foo", 
            PortletSession.APPLICATION_SCOPE).toString());
    }
    return "somewhere/view";
}