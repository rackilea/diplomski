@RequestMapping(value = "/submitrule", method = RequestMethod.POST)
      public String addruleSerch(@ModelAttribute RuleForm ruleForm) {
     //Here you will have access to your  object
     ruleForm.getRule().getId();// rule selected in the form
     ... your business logic 
     return "redirect:/someUrl";
}