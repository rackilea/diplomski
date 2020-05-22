public void onAlfrescoTicketReceived(Mono<Ticket> ticket) {
    UI ui = UI.getCurrent();
    ticket
        .log()
        .subscribe(
            consumer -> {
              this.sessionService.setTicket(consumer.getTicket());
              ui.access(() -> ui.navigate("route"));
            });
}