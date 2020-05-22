public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        BufferedServletResponseWrapper bufferedResponse = new BufferedServletResponseWrapper(
                httpServletResponse);

        // pass the wrappers on to the next entry
        chain.doFilter(httpServletRequest, bufferedResponse);

        String responseData = bufferedResponse.getResponseData();
        String encryptedResponseData = encrypt(responseData);
        OutputStream outputStream = httpServletResponse.getOutputStream();
        outputStream.write(encryptedResponseData.getBytes());
        outputStream.flush();
        outputStream.close();
    }