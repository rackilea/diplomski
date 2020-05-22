public class UserKeySetPublickeyAuthenticator implements PublickeyAuthenticator {
    private final Map<String, Collection<? extends PublicKey>> userToKeySet;

    public UserKeySetPublickeyAuthenticator(Map<String, Collection<? extends PublicKey>> userToKeySet) {
        this.userToKeySet = userToKeySet;
    }

    @Override
    public boolean authenticate(String username, PublicKey key, ServerSession session) {
        return KeyUtils.findMatchingKey(key, userToKeySet.getOrDefault(username, Collections.emptyList())) != null;
    }

}