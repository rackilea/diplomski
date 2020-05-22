Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
    String username = ((UserDetails)principal).getUsername();
    } else {
    String username = principal.toString();
    }