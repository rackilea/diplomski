Flux.just(
  new Request(redRequest, RED),
  new Request(blueRequest, BLUE),
  new Request(greenRequest, GREEN)
)
.parallel()
.flatMap(request -> 
  client.getBytes(request)
    .map(response -> new Response(response.get(0), request.color))
)
.sequential()
.collectList()
.map(response -> {
  byte[] redBytes = response.bytes;
  Color color = response.color;
  // 
})