Completable chain = completable1
    .andThen(completable2);

if (condition) {
    chain = chain.andThen(completable3);
}

chain.subscribe();