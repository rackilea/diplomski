public class PasswordValidator implements PasswordValidationService{
    private Set<PasswordRule> rules = new HashSet<PasswordRules>();

    public PasswordValidator(PasswordRule... args){
        for(PasswordRule r : args)
            rules.add(r);
    }

    public List<String> validate(String password){
        List<String> failures = new ArrayList<String>();
        for(PasswordRule r : rules)
            if(!r.check(password))
                failures.add(r.getError());
        return failures;
    }
}