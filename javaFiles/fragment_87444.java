public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
        res.getWriter().write(JsonBuilder //my util class for creating json strings
                .put("timestamp", DateGenerator.getDate())
                .put("status", 403)
                .put("message", "Access denied")
                .build());
    }
}