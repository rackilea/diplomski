Single.zip(firstRequest, secondRequest, (firstReply, secondReply) -> {
    // ...do stuff with the replies and compose some result
    //    to be handled in onSuccess()
    return firstReply.body().toString() + secondReply.body().toString();
})
.subscribe(
    result -> {
        System.out.println("## onSuccess(" + result + ")");
    },
    error -> {
        System.err.println("## onError(" + error.getMessage() + ")");
    }
);