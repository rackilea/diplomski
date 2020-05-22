Pattern pattern = Pattern.compile("unixtime: (\\d+)", Pattern.MULTILINE);

HttpClient client = HttpClient.newHttpClient();

HttpResponse<String> response = client.send(HttpRequest.newBuilder()
        .GET()
        .uri(new URI("http://worldtimeapi.org/api/ip.txt"))
        .build(), HttpResponse.BodyHandlers.ofString());

Matcher matcher = pattern.matcher(response.body());

if (matcher.find()) {
    System.out.println(matcher.group(1));
}