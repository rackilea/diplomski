public String resetPassword(
    @ModelAttribute("password") @Valid PasswordPair password, BindingResult result) {
    ...
}

@InitBinder("password")