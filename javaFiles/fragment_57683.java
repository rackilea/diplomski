@Component
@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler 
{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Authentication authentication) 
                    throws IOException, ServletException, RuntimeException 
    {
        HttpSession session = httpServletRequest.getSession();
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("username", authUser.getUsername());
        //set our response to OK status
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(authority -> 
                                { 
                                    if(authority.getAuthority().equals("ADMIN_ROLE")) 
                                    { 
                                        session.setAttribute("role", AppRole.ADMIN);
                                        try
                                        {
                                            //since we have created our custom success handler, its up to us to where
                                            //we will redirect the user after successfully login
                                            httpServletResponse.sendRedirect("/admin/home");
                                        } 
                                        catch (IOException e) 
                                        {
                                            throw new RuntimeException(e);
                                        }                                                                           
                                    }
                                    else if (authority.getAuthority().equals("CUSTOMER_ROLE"))
                                    {
                                        session.setAttribute("role", AppRole.CUSTOMER);
                                        try
                                        {
                                            //since we have created our custom success handler, its up to us to where
                                            //we will redirect the user after successfully login
                                            httpServletResponse.sendRedirect("/user/home");
                                        } 
                                        catch (IOException e) 
                                        {
                                            throw new RuntimeException(e);
                                        }   
                                    }
                                });

    }
}