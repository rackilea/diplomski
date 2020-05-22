public synchronized void addCookie(Cookie cookie) {
    if (cookie != null) {
        // first remove any old cookie that is equivalent
        for (Iterator<Cookie> it = cookies.iterator(); it.hasNext();) {
            if (cookieComparator.compare(cookie, it.next()) == 0) {
                it.remove();
                break;
            }
        }
        if (!cookie.isExpired(new Date())) {
            cookies.add(cookie);
        }
    }
}