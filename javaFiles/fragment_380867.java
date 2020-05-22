public List<HttpCookie> getCookiesList() throws Exception {
    List<HttpCookie> httpCookiesList = inmemoryCookieStore.get(clientURI);
    return httpCookiesList;
}

public void addCookie(HttpCookie newCookie) {
        inmemoryCookieStore.add(clientURI, newCookie);
}