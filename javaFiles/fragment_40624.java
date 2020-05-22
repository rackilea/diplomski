final List<Single<Message<Object>>> requests = asList(firstRequest, secondRequest, ...);

Single.zip(requests, replies -> {
    // ...do stuff with the array of replies
    return null;
})
.subscribe(...);