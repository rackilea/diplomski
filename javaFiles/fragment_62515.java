@RequestMapping(value="/logOut", method = RequestMethod.POST )
public String logOut(Model model, RedirectAttributes redirectAttributes)  {
    redirectAttributes.addFlashAttribute("message", "success logout");
    System.out.println("/logOut");
    return "redirect:/home";
}