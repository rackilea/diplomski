enum StatutCode
{
  ONE,
  TWO,
  THREE,
  FOUR
};

enum Domain
{
  DOMAIN_1( EnumSet.of( StatutCode.ONE, StatutCode.TWO ) ),
  ...
  DOMAIN_N( EnumSet.of( StatutCode.TWO, StatutCode.THREE ) );

  private final EnumSet< StatutCode> validStatCodes;

  Domain( EnumSet< StatutCode > validStatCodes )
  {
    this.validStatCodes = validStatCodes;
  }

  public boolean isValidCode ( final StatutCode code )
  {
    return validStatCodes.contains( code );
  }
}

class Statut {
    final Domain staDomain;
    final StatutCode staCode;

    Statut(
      final Domain staDomain,
      final StatutCode staCode
    )
    {
      if ( ! staDomain.isValidCode( staCode ) )
      {
        throw new IllegalArgumentException(
            "Invalid code " + staCode + " for domain " + staDomain
          );
      }

      this.staDomain = staDomain;
      this.staCode = staCode;
    }

}