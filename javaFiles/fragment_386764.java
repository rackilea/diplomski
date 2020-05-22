if (auth instanceof AnonymousAuthenticationToken) {
  if (!resource.isClientOnly()) {
    throw new InsufficientAuthenticationException(
        "Authentication is required to obtain an access token (anonymous not allowed)");
  }
}