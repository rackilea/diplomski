public static User getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof CustomUserDetails) {
                 CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
                return userDetails.getUser();
            }
        }
        throw new IllegalStateException("User not found!");
    }