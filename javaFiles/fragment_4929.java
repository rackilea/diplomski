public class BinarySafeCharacterEncodingFilter extends CharacterEncodingFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if(!"image/gif".equals(response.getContentType())){
            super.doFilterInternal(request, response, filterChain);
        }


    }

}