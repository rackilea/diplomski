final TransactionProposalRequest proposalRequest = client.newTransactionProposalRequest();

    final ChaincodeID chaincodeID = ChaincodeID.newBuilder()
            .setName("myCC")
            .setVersion("1.0")
            .setPath("github.com/yourpackage/chaincode/")
            .build();

    proposalRequest.setChaincodeID(chaincodeID);
    proposalRequest.setFcn("fcn");
    proposalRequest.setProposalWaitTime(TimeUnit.SECONDS.toMillis(10));
    proposalRequest.setArgs(new String[]{"arg1", "arg2"});