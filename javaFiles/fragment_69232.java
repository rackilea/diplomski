public Authentication authenticateUserAndSetSession(String username,HttpServletRequest request){

          UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);

          Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

          SecurityContextHolder.getContext().setAuthentication(authentication);

          request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

          return authentication;
      }