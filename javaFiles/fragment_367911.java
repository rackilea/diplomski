String convertedString = "key=value&key=value";

return client.post().uri("http://www.some_host.com/receive.php?" + convertedString)
        .header(HttpHeaders.USER_AGENT, "Mozilla/5.0")
        .accept(MediaType.APPLICATION_XML)
        // .contentType(MediaType.APPLICATION_XML)
        .retrieve()
        .bodyToMono(NotificationEchoResponse.class);