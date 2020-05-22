HttpURLConnection firstCall = (HttpURLConnection) new URL("http://www.google.com").openConnection();
        firstCall.connect();
        List<HttpCookie> cookieList = HttpCookie.parse(firstCall.getHeaderField("Set-Cookie"));
        firstCall.disconnect();
        StringBuilder cookies = new StringBuilder();
        for(HttpCookie cookie:cookieList) {
            //if(cookie.SOME_VALIDATION) {
                if(cookies.length() > 0) {
                    cookies.append("; ");
                }
                cookies.append(cookie.toString());
            //}
        }
        HttpURLConnection secondCall = (HttpURLConnection) new URL("http://www.google.com").openConnection();
        secondCall.setRequestProperty("Cookie", cookies.toString());
        secondCall.connect();
        //dosomething
        secondCall.disconnect();