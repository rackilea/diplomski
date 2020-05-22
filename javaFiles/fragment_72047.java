// create the textboxes of the form with their proper form names
TextBox tbName = new TextBox();
tbName.setName( "name" );
TextBox tbEmail = new TextBox();
tbEmail.setName( "email" );
TextBox tbMessage = new TextBox();
tbMessage.setName( "message" );

// create the form panel
final FormPanel emailFormPanel = new FormPanel();
// TODO: add the form panel to some kind of parent widget / ui object
emailFormPanel.setAction( "/contextRoot/path/to/email.php" );
emailFormPanel.setMethod( "POST" );

// add the textboxes to the form panel
emailFormPanel.add( tbName );
emailFormPanel.add( tbEmail );
emailFormPanel.add( tbMessage );

// create the form submit button
Button btnSubmit = new Button( "Submit", new ClickHandler() {

  @Override
  public void onClick(ClickEvent event) {
    emailFormPanel.submit();
  }

} );

// create the formpanel handler for a successful submit
// any error message ("did you forget to ...") will be returned here
emailFormPanel.addSubmitCompleteHandler( new SubmitCompleteHandler() {

  @Override
  public void onSubmitComplete(SubmitCompleteEvent event) {

    String errorString = event.getResults();
    // TODO: decide what to do with a potential non-empty string
  }
} );