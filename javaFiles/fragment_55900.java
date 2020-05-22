Enumeration<String> headers = request.getHeaderNames();
    while (headers.hasMoreElements()) {
        final String headerName = headers.nextElement();
        conn.addRequestProperty(headerName, request.getHeader(headerName));
    }

    // Cast to a HttpURLConnection
    if (conn instanceof HttpURLConnection) {
        HttpURLConnection httpConnection = (HttpURLConnection) conn;
        int code = httpConnection.getResponseCode();

        if (code < 300) {
            Map<String, List<String>> map = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                final String key = entry.getKey();
                if(Objects.equals(key, "Transfer-Encoding")) continue;
                String value = String.valueOf(map.get(key));
                if (value != null && value.length() > 0)
                    value = value.substring(1, value.length() - 1);
                response.setHeader(key, value);
            }
            fastCopy(conn.getInputStream(), response.getOutputStream());
        }
        response.setStatus(code);
    } else {
        System.err.println("error - not a http request!");
    }
}