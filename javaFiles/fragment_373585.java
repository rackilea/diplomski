// org.springframework.validation.SmartValidator - implemented by
//     LocalValidatorFactoryBean, which is funny as it is not a FactoryBean per se (just saying)
@Autowired
SmartValidator validator;

public String saveAccount(@ModelAttribute Account account, BindingResult result) {
    // ... custom logic
    validator.validate(account, result, Account.Step1.class);
    if (result.hasErrors()) {
        // ... on binding or validation errors
    } else {
        // ... on no errors
    }
    return "";
}