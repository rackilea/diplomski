class BasicAuthInterceptor implements ClientHttpRequestInterceptor {

    private final AuthService authService;

    public BasicAuthHeaderInterceptor(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        if(isApplicable(request)){
            String token = Base64Utils.encodeToString((authService.getUsername() + ":" + authService.getpassword()).getBytes(Charset.forName("UTF-8")));
            request.getHeaders().add("Authorization", "Basic " + token);
        }
        return execution.execute(request, body);
    }

}

class TokenInterceptor implements ClientHttpRequestInterceptor {

    private final AuthService authService;

    public TokenHeaderInterceptor(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        if(isApplicable(request)){
            request.getHeaders().add("Authorization", "Bearer " + tokenService.getToken());
        }
        return execution.execute(request, body);
    }

}