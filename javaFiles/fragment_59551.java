public String intercept(ActionInvocation Invocation) throws Exception {

    final ActionContext ac = invocation.getInvocationContext();
    HttpServletResponse response = (HttpServletResponse) ac.get(StrutsStatics.HTTP_RE‌​SPONSE);
    //HttpServletResponse response = ServletActionContext.getResponse();

    response.addHeader("X-Frame-Options", "SAMEORIGIN");
    response.addHeader("Content-Security-Policy-Report-Only", "default-src 'self'; script-src 'self' 'unsafe-inline'; object-src 'none'; style-src 'self' 'unsafe-inline'; img-src 'self'; media-src 'none'; frame-src 'none'; font-src 'self'; connect-src 'self'; report-uri REDACTED");
    response.addHeader("X-Content-Security-Policy-Report-Only", "default-src 'self'; script-src 'self' 'unsafe-inline'; object-src 'none'; style-src 'self' 'unsafe-inline'; img-src 'self'; media-src 'none'; frame-src 'none'; font-src 'self'; connect-src 'self'; report-uri REDACTED");
    return Invocation.invoke();
}