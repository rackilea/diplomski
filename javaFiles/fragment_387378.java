@RequestMapping(value = "stepTwo", method = RequestMethod.POST)
public String stepTwo(@Validated(Account.ValidationStepTwo.class) Account account, Errors errors) {
  if (errors.hasErrors()) {
      return VIEW_STEP_TWO;
  }
  return "redirect:summary";
}