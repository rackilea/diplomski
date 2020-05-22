newAuthorities = projectService.getRolesForUser(username);
UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), newAuthorities);
        OAuth2Authentication authentication = (OAuth2Authentication)SecurityContextHolder.getContext().getAuthentication();
        Collection<OAuth2AccessToken> accessTokens = tokenStore.findTokensByUserName(principal.getName());
        OAuth2Authentication auth2 = new OAuth2Authentication(authentication.getOAuth2Request(), newAuth);

        accessTokens.forEach(token -> {
            if (!token.isExpired()) {
                tokenStore.storeAccessToken(token, auth2);
            }
        });