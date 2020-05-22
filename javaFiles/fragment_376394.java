HttpResponse response = HttpRequest
                .create(new URI("http://stackoverflow.com/"))
                .GET()
                .response();

String body = response.body(HttpResponse.asString());