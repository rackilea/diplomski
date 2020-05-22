Mono.just(userId)
    .map(repo::findById)
    .handle((user, sink) -> {
        if(!isValid(user)){
            sink.error(new InvalidUserException());
        } else if (isSendable(user))
            sink.next(user);
        }
        else {
            //just ignore element
        }
    })