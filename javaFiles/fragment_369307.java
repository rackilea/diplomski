public void doFilter(ServletRequest request, ServletResponse response,FilterChain filterChain) throws IOException, ServletException {

    if ((request instanceof HttpServletRequest)&& (response instanceof HttpServletResponse)) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // is session expire control required for this request?
        if (isSessionControlRequiredForThisResource(httpServletRequest)) {
            // is session invalid?
            if (isSessionInvalid(httpServletRequest)) {
                /**/


                String redirectURL = httpServletResponse.encodeRedirectURL(httpServletRequest.getContextPath() +"/"+ getTimeoutPage());

                if (isAJAXRequest(httpServletRequest)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><partial-response><redirect url=\"").append(redirectURL).append("\"></redirect></partial-response>");
                    httpServletResponse.setHeader("Cache-Control", "no-cache");
                    httpServletResponse.setCharacterEncoding("UTF-8");
                    httpServletResponse.setContentType("text/xml");
                    PrintWriter pw = response.getWriter();
                    pw.println(sb.toString());
                    pw.flush();
                }else{
                    String timeoutUrl = httpServletRequest.getContextPath()+ "/" + getTimeoutPage();
                    logger.info("session is invalid! redirecting to timeoutpage : "+ timeoutUrl);
                    httpServletResponse.sendRedirect(timeoutUrl);
                }

                return;
            }
        }
    }
    filterChain.doFilter(request, response);
}

private boolean isAJAXRequest(HttpServletRequest request) {
    boolean check = false;
    String facesRequest = request.getHeader("Faces-Request");
    if (facesRequest != null && facesRequest.equals("partial/ajax")) {
        check = true;
    }
    return check;
}