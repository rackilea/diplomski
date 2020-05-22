@RequestMapping(method = RequestMethod.GET, params = {"clearForm"})
public String clearForm(@ModelAttribute("parking") Parking parking, WebRequest request, SessionStatus sessionStatus) {
    sessionStatus.setComplete();
    request.removeAttribute("parking", WebRequest.SCOPE_SESSION);
    return "redirect:/" +VIEW_PARKING;
}