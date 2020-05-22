String cookieValue = null;
for (Map.Entry<String, NewCookie> entry : loginResponse.getCookies().entrySet()) {
    String key = entry.getKey();
    if ("sessionToken".equals(key)) {
        cookieValue = entry.getValue().toString();
        cookieValue = cookieValue.substring(0, cookieValue.indexOf(";"));
    }
}