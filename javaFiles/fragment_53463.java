Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
UserDetails userDetails = null;
if (principal instanceof UserDetails) {
  userDetails = (UserDetails) principal;
}
String userName = userDetails.getUsername();