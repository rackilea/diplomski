public class MyVerifier extends SecretVerifier {
    public int verify(String identifier, char[] secret)
                     throws IllegalArgumentException {
        ApplicationUser user = loadUser(identifier);
        //user contains both user hints and roles
        if (user!=null
              && compare(user.getPassword().toCharArray(), secret)) {
            Request request = Request.getCurrent();
            request.getClientInfo().setUser(user);
            return SecretVerifier.RESULT_VALID;
        } else {
            return SecretVerifier.RESULT_INVALID;
        }
    }
}