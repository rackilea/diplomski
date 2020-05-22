public enum Includes implements SomeBaseClass {
  VENDOR ("Vendor"),
  OFFERS_CODES ("OffersCodes"),
  REMAINING_REDEMPTIONS ("RemainingRedemptions");

  private String urlParam;

  Includes(String urlParam) {
    this.urlParam = urlParam;
  }

  @Override
  public String getUrlParam() {
    return urlParam;
  }

  @Override
  public void setUrlParam(String urlParam) {
    this.urlParam = urlParam;
  }
}