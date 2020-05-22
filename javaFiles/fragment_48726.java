public class UserAuthenticationToken extends AbstractAuthenticationToken {

        private static final long serialVersionUID = 1L;
        private final Object principal;
        private Object credentials;

        /**Store the principal object(you can store any object like userbean anything) as principal,userdetails as credentials and authorities in Authentication object**/
        public UserAuthenticationToken(Object principal, Object credentials,
                Collection<? extends GrantedAuthority> authorities) {
            super(authorities);
            this.principal = principal;
            this.credentials = credentials;
            super.setAuthenticated(true);
        }

        public Object getCredentials() {
            return this.credentials;
        }

        public Object getPrincipal() {
            return this.principal;
        }

    }