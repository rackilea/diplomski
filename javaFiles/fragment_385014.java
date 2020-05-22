Client client = ClientBuilder.newClient();
WebTarget target = client.target("http://someendpoint");

SseEventSource eventSource = SseEventSource.target(target)
                                           .reconnectingEvery(5, TimeUnit.SECONDS)
                                           .build();
eventSource.register(payload -> System.out.println(payload),   // Consumer<InboundSseEvent>
                     error -> error.printStackTrace(),         // Consumer<Throwable>
                     () -> System.out.println("no more events"));
eventSource.open();
// and eventually
eventSource.close();