public static void setupSecurityContext(String username, String password, String... groups)
{
  List<GrantedAuthority> authorities = new ArrayList<>();
  for (String group : groups)
  {
    authorities.add(new SimpleGrantedAuthority(group));
  }

  UserDetails user = new UserDetails(username, password, authorities);
  UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, password);
  SecurityContextHolder.getContext().setAuthentication(token);
}