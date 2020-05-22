final Collection<ProposalResponse> responses = channel.sendTransactionProposal(proposalRequest);

    CompletableFuture<BlockEvent.TransactionEvent> txFuture = channel.sendTransaction(responses, client.getUserContext());

    BlockEvent.TransactionEvent event = txFuture.get();

    System.out.println(event.toString());