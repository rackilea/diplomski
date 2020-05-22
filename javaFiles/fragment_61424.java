private static String redirectUrl;

@Value("${backend.authorize.url}")
public void setRedirectUrl(String url) {
    redirectUrl = url;
}