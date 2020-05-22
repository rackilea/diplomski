@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockOAuth2User.WithMockOAuth2UserSecurityContextFactory.class)
public @interface WithMockOAuth2User {

    WithMockOAuth2Client client() default @WithMockOAuth2Client();

    WithMockUser user() default @WithMockUser();

    class WithMockOAuth2UserSecurityContextFactory implements WithSecurityContextFactory<WithMockOAuth2User> {

        /**
         * Sadly, #WithMockUserSecurityContextFactory is not public,
         * so re-implement mock user authentication creation
         *
         * @param user
         * @return an Authentication with provided user details
         */
        public static UsernamePasswordAuthenticationToken getUserAuthentication(final WithMockUser user) {
            final String principal = user.username().isEmpty() ? user.value() : user.username();

            final Stream<String> grants = user.authorities().length == 0 ?
                    Stream.of(user.roles()).map(r -> "ROLE_" + r) :
                    Stream.of(user.authorities());

            final Set<? extends GrantedAuthority> userAuthorities = grants
                    .map(auth -> new SimpleGrantedAuthority(auth))
                    .collect(Collectors.toSet());

            return new UsernamePasswordAuthenticationToken(
                    new User(principal, user.password(), userAuthorities),
                    principal + ":" + user.password(),
                    userAuthorities);
        }

        @Override
        public SecurityContext createSecurityContext(final WithMockOAuth2User annotation) {
            final SecurityContext ctx = SecurityContextHolder.createEmptyContext();
            ctx.setAuthentication(new OAuth2Authentication(
                    WithMockOAuth2Client.WithMockOAuth2ClientSecurityContextFactory.getOAuth2Request(annotation.client()),
                    getUserAuthentication(annotation.user())));
            SecurityContextHolder.setContext(ctx);
            return ctx;
        }
    }
}