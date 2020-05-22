// create the textboxes of the form with their proper form names
final TextBox tbName = new TextBox();
final TextBox tbEmail = new TextBox();
final TextBox tbMessage = new TextBox();

// create the form submit button
Button btnSubmit = new Button( "Submit", new ClickHandler() {

  @Override
  public void onClick(ClickEvent event) {
    submitEmailFormRequestBuilder( tbName, tbEmail, tbMessage );

  }

} );
// TODO: add textboxes and Submit-Button to the DOM-tree