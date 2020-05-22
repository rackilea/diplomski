String s=new String(client1.get().uri("/v1/payments/123" )
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectBody().returnResult().getResponseBody());

    System.out.println(s);