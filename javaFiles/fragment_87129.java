private getUser() {
  Authentication authentication = 
  SecurityContextHolder.getContext().getAuthentication();
  JwtUser user = (JwtUser)authentication.getPrincipal();
  User current_user = userRepository.findOne(user.getId());   
  return current_user;
}