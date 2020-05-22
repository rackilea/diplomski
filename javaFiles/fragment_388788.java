@RequestMapping(method=RequestMethod.POST)
public @ResponseBody Map<String, ? extends Object> create(@RequestBody Account account, HttpServletResponse response) {
    Set<ConstraintViolation<Account>> failures = validator.validate(account);
    if (!failures.isEmpty()) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return validationMessages(failures);
    } else {
        accounts.put(account.assignId(), account);
        return Collections.singletonMap("id", account.getId());
    }
}