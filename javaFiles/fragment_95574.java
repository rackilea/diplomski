...
if (!allPlayersCalled) {
    CycleDTO dto = new CycleDTO();
    dtp.setPlayersRemaininf(updatedPlayersRemaining)
    dto.setPlayerHands(updatedPlayerHands);
    dto.setBets(updatedBets);
    dto.setTotalPot(updatedTotalPot);

    bettingCycle(dto); 

...