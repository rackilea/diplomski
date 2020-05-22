final CookieManager cookieManager = CookieManager.getInstance();
final HttpResponse response = ...
final Header[] cookies = response.getHeaders("set-cookie");
for (Header cooky : cookies) {
    cookieManager.setCookie(url, cooky.getValue());
}