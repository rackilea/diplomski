rx.Observable
    .zip(userObs, gameObs, (userObj, game) -> {
        // Combine the user & game objects and pass them to the
        // next Rx operation.
        return new UserAndActiveGame(userObj, game);
    })
    .filter(userAndActiveGame -> {
        // Remove this filter if you want errors to make it to the subscriber.
        return userAndActiveGame.getUserObj().getStatus() == ErrorCodes.STATUS_OK;
    })
    .flatMap(userAndActiveGame -> {
        // Remove this check if you filter errors above.
        if (userAndActiveGame.getUserObj().getStatus() != ErrorCodes.STATUS_OK) {
            return Observable.just(new FindSeatResult(-1));
        }

        return context.getActiveGameManager().updateGame(userAndActiveGame.getGame())
            .map(gameObj -> {
                if (gameObj.getStatus() != ErrorCodes.STATUS_OK) {
                    return new FindSeatResult(-2);
                }

                User user =...; // Whatever you are doing to get this in your example code.
                return new FindSeatResult(ErrorCodes.STATUS_OK, user, gameObj);
            });
    })