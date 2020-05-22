public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
    Authentication authentication) throws IOException, ServletException {
 // ... get target url
 String targetUrl = "";
 try {
            response.setStatus(HttpServletResponse.OK);
            PrintWriter writer = response.getWriter();
            writer.write(targetUrl);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // ignore
            logger.error(e.getMessage(), e);
        }