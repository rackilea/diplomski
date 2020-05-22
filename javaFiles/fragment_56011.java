HttpUrl localUrl = HttpUrl.parse("http://YourlocalIPV4Address:44338/api/authorize/login")
Request request = new Request.Builder()
        .url(localUrl)
        .addHeader("Content-Type","application/json")
        .post(formBody)
        .build();