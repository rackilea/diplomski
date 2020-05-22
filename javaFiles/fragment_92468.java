public String myGetRequest(Model model) {
    if (!model.containsAttribute("Booking")) {
        // Add the named model attribute here
        model.addAttribute("Booking", new Booking());
    }
    return "booking/reserve";
}

@PostMapping(...)
public String myPostRequest(
    @Valid @ModelAttribute Booking booking,
    final BindingResult bindingResult,
    final RedirectAttributes redirectAttributes
) {
    if (bindingResult.hasErrors()) {
        // Adds the validation errors
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Booking", bindingResult);

        // Set the model attribute
        redirectAttributes.addFlashAttribute("Booking", booking);
        return "redirect:/booking/reserve";
    }
    // Otherwise...
    return "redirect:/booking/show";
}