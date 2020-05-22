boolean firstHeader = true;
    for (String header : cookiesHeaders) {
        if (firstHeader) {
            httpResponse.setHeader("Set-Cookie", String.format("%s; %s", header, "SameSite=Strict"));
            firstHeader = false;
            continue;
        }
        httpResponse.addHeader("Set-Cookie", String.format("%s; %s", header, "SameSite=Strict"));
    }