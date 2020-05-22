WebClient client = WebClient.create("http://www.example.com/");
    client.post()
       .syncBody("test")
       .exchange()
       .flatMap(response->response.body((t,m)->t.getBody().next()))
       .subscribe( r -> {
              System.out.println("Available bytes:" + r.readableByteCount());
              final int limit = r.readableByteCount() < 500 ? r.readableByteCount() : 500;
              System.out.println("Limit:" + limit);
              byte[] dst = new byte[limit];
              r.asByteBuffer().get(dst, 0, limit);
              System.out.println("body=" + new String(dst, StandardCharsets.UTF_8));
          },
          t -> System.out.println(t));