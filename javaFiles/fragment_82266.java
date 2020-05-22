@RequestMapping(value = "/update", method = RequestMethod.POST)
public String handleSaveRequest(RedirectAttributes redirectAttributes,
                                Model model) {
    redirectAttributes.addFlashAttribute("myFlashAttr", "FOOBAR");
    redirectAttributes.addAttribute("myAttr", "Some Value");

    return "redirect:/confirmationpage?myAttr={myAttr}";
}