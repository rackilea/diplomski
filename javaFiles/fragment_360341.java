@Bean
public AuthenticationEntryPoint unauthorizedEntryPoint() {
    AuthenticationEntryPoint entryPoint = new AuthenticationEntryPoint() {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
                AuthenticationException authException) throws IOException, ServletException {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    };
    return entryPoint;
}