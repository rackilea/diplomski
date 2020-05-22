CommitRequest request = CommitRequest.newBuilder()
    .setMode(CommitRequest.Mode.NON_TRANSACTIONAL)
    .setMutation(Mutation.newBuilder()
        .addInsert(entity1)
        .addInsert(entity2))
    .build();