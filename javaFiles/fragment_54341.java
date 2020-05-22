receiver.consumeManualAck("queue.A")
        .flatMap(ad -> {
           Mono<OutboundMessage> outboundMessageMono =
                Mono.just(new OutboundMessage("", "queue.B", ad.getBody()));
           return sender.send(outboundMessageMono)
                        .doFinally(signalType -> {
                            if (signalType == SignalType.ON_COMPLETE) {
                               ad.ack();
                            } else {
                               ad.nack(false);
                           }
                         });
         });