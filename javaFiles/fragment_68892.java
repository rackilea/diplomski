.subscribe((results) -> {
    // You don't need this if you filter errors above.
    if (findSeatResult.getStatus() == -1) {
        return;
    }

    int status = findSeatResult.getStatus();
    User user = findSeatResult.getUser();
    ActiveGame game = findSeatResult.getGame();

    replyObj.reply(new JsonObject()
                .putString("action", CommandActions.FIND_SEAT)
                .putNumber("status", status);
                .putNumber("game_id", game.getGameId())
            );
});