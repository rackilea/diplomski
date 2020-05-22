@RequestMapping("/automatic/login/test")
public @ResponseBody String automaticLoginTest(HttpServletRequest request) 
{
    String username = "anyUserName@YourSite.com";

    Boolean result = authenticateUserAndInitializeSessionByUsername(username, userDetailsManager, request);

    return result.toString();
}

public boolean authenticateUserAndInitializeSessionByUsername(String username, UserDetailsManager userDetailsManager, HttpServletRequest request)
{
    boolean result = true;

    try
    {
        // generate session if one doesn't exist
        request.getSession();

        // Authenticate the user
        UserDetails user = userDetailsManager.loadUserByUsername(username);
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());

      result = false;
    }

    return result;
}