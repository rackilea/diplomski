if (securityContext != null && securityContext.getUserPrincipal() instanceof KeycloakPrincipal) {
    KeycloakPrincipal principal = ((KeycloakPrincipal) securityContext.getUserPrincipal());
    AccessToken token = principal.getKeycloakSecurityContext().getToken();
    // IDToken token = principal.getKeycloakSecurityContext().getIdToken();

    System.out.println("User logged in: " + token.getPreferredUsername());
} else {
    System.out.println("SecurityContext could not provide a Keycloak context.");
}