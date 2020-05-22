enum ValiantHeroWithPrincessSavingTendencies {
  SUPERMARIO(Quotes.TYPICAL_QUOTE_FROM_MARIO),
  ZELDA(Quotes.TYPICAL_QUOTE_FROM_ZELDA);

  private String aPreparedQuotePurportedToBeSpontaneousAlmostImpulsive;

  public String getQuoteUnderStressfulCircumstances() {
    return aPreparedQuotePurportedToBeSpontaneousAlmostImpulsive;
  }

  private ValiantHeroWithPrincessSavingTendencies(String quote) {
    aPreparedQuotePurportedToBeSpontaneousAlmostImpulsive = quote;
  }

  private static class Quotes {
    private static final String TYPICAL_QUOTE_FROM_ZELDA = "Have at ya!";
    private static final String TYPICAL_QUOTE_FROM_MARIO = "We, wagliu'!";
  }
}