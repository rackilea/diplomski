@RequestMapping(value="/gotoNextPage",method = RequestMethod.GET)
public String gotoNextPage(Model model){
    LOG.debug("Inside gotoNextPage!!!!!!");
    model.addAttribute("message", "next page");
    return "redirect:nextpage.html";
}