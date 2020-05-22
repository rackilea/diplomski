public void MatchInitiatedCallback implements ResultCallback {

    @Override
    public void onResult(TurnBasedMultiplayer.InitiateMatchResult result) {
        // Check if the status code is not success;
        if (result.getStatus != GamesStatusCodes.STATUS_OK) {
            showError(statusCode);
            return;
        }

        TurnBasedMatch match = result.getMatch();

        // If this player is not the first player in this match, continue.
        if (match.getData() != null) {
            showTurnUI(match);
            return;
        }

        // Otherwise, this is the first player. Initialize the game state.
        initGame(match);

        // Let the player take the first turn
        showTurnUI(match);
    }
}