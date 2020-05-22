class GoogleAAuthenticationProcessingFilter extends OAuth2ClientAuthenticationProcessingFilter {

        @Override
        protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                FilterChain chain, Authentication authResult) throws IOException, ServletException {
            super.successfulAuthentication(request, response, chain, authResult);
            // here you can redirect to whatever location you want to

        }

    }

class GoogleBAuthenticationProcessingFilter extends OAuth2ClientAuthenticationProcessingFilter {

        @Override
        protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                FilterChain chain, Authentication authResult) throws IOException, ServletException {
            super.successfulAuthentication(request, response, chain, authResult);
            // here you can redirect to whatever location you want to

        }

    }