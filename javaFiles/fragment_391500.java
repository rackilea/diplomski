MyApp.init() {
  super.init();

  org.apache.wicket.Application.getHeaderContributorListenerCollection().add(new IHeaderContributor() {

    public void renderHead(IHeaderResponse response) {
      response.renderCssReference(Resources.CSS_BASE);
    }
  });
}