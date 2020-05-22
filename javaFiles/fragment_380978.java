String accessToken = "";
    String expires = "";

    Matcher matcher = pattern.matcher(token.trim());
    if(matcher.matches()) {
        accessToken = matcher.group(1);
        expires = matcher.group(2);
    } else {
        return new JSONObject()
                .put("error", "OathBean: accessToken is null");
    }