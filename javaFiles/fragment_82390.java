class SearchResultsPage extends WebPage {

  public static PageParameters convertModelToParam(SearchResultsModel model) {
     ...
  }

  public static SearchResultModel convertParamToModel( PageParameters param ) {
    //this is for convenience only
    ...
  }

  public SearchResultsPage( PageParameters param ) {
    this( convertParamToModel( param ) );
  }

  private SearchResultsPage(SearchResultsModel model) {
    // display the data in the model
  }
}