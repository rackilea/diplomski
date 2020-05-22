protected Authentication attemptSwitchUser(HttpServletRequest request) {
    Authentication switchTo = super.attemptSwitchUser(request);
    Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
    // Inspect currentUser (e.g. authorities) and switchTo to see if valid combination
    // Raise AuthenticationException if not

    return switchTo;
}