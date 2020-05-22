public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // Perform the checks from the super class
        super.additionalAuthenticationChecks(userDetails, authentication);

        // Cast the UserDetails to the implementation you use
        User user = (User) userDetails;

        // Check the confirmed status
        if (!user.isAccountConfirmed()) {
            throw new AccountNotConfirmedException("Account is not confirmed yet.");
        }
    }

    public static class AccountNotConfirmedException extends AuthenticationException {
        public AccountNotConfirmedException(String message) {
            super(message);
        }
    }

}