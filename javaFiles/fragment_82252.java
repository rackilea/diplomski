if (statusTextTokens.length != 0 && statusTextTokens[0] instanceof Token.StatusTextToken) {
    LOG.info("Instance of StatusTextToken");
}

if (profileLocationTokens.length != 0 && profileLocationTokens[0] instanceof Token.ProfileLocationToken) {
    LOG.info("Instance of ProfileLocationToken");
}

if (profileDescriptionTokens.length != 0 && profileDescriptionTokens[0] instanceof Token.ProfileDescriptionToken) {
    LOG.info("Instance of ProfileDescriptionToken");
}