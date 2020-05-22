fun main(args: Array<String>) {    
    val client = HttpClient.newHttpClient()

    val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.google.com"))
            .GET()
            .build()

    println("Starting download...")
    client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("google.html")))
    println("Done with download.")
}