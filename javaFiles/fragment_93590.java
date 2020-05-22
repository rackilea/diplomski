BasicClientCookie cookie1 = new BasicClientCookie("foo", "123");
cookie1.setVersion(0);
cookie1.setDomain("origin.com");
cookie1.setPath("/");
BasicClientCookie cookie2 = new BasicClientCookie("bar", "123");
cookie1.setVersion(0);
cookie1.setDomain("origin.com");
cookie1.setPath("/");

BasicCookieStore cookieStore = new BasicCookieStore();
cookieStore.addCookie(cookie1);
cookieStore.addCookie(cookie2);

NetscapeDraftSpec spec = new NetscapeDraftSpec();
List<Header> headers = spec.formatCookies(cookieStore.getCookies());
for (Header header: headers) {
    System.out.println(header);
}