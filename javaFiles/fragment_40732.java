public static boolean isRememberMeAuthenticated() {
    // Check authentication exists
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null) {
        return false;
    }

    return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
}