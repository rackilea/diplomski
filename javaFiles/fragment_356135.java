@RequestMapping(value = "/accounts", method = RequestMethod.POST)
 public String handle(Account account, BindingResult result, RedirectAttributes redirectAttrs) {
   if (result.hasErrors()) {
     return "accounts/new";
   }
   // Save account ...
   redirectAttrs.addAttribute("id", account.getId()).addFlashAttribute("message", "Account created!");
   return "redirect:/accounts/{id}";
 }