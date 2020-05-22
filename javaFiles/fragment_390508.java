public class UniquePrincipalSecurityManager extends org.apache.shiro.mgt.DefaultSecurityManager {

    @Override
    public Subject login(Subject subject, AuthenticationToken token) throws AuthenticationException {

        String loginPrincipal = (String) token.getPrincipal();
        DefaultSessionManager sm = (DefaultSessionManager) getSessionManager();
        for (Session session : sm.getSessionDAO().getActiveSessions()) {
            SimplePrincipalCollection p = (SimplePrincipalCollection) session
                    .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (p != null && loginPrincipal.equals(p.getPrimaryPrincipal())) {
                throw new AlreadyAuthenticatedException();
            }

        }
        return super.login(subject, token);
    }

}