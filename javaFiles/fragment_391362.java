private void createTextField()
{
    NumberFormat nf = NumberFormat.getIntegerInstance();
    textField = new TextField();

    // add filter to allow for typing only integer
    textField.setTextFormatter( new TextFormatter<>( c ->
    {

        if (c.getControlNewText().isEmpty()) {
            return c;
        } // for the No.2 issue in the comment

        ParsePosition parsePosition = new ParsePosition( 0 );
        Object object = nf.parse( c.getControlNewText(), parsePosition );

        if ( object == null || parsePosition.getIndex() < c.getControlNewText().length() )
        {
            return null;
        }
        else
        {
            return c;
        }
    } ) );

    textField.setText( getString() );

    textField.setMinWidth( this.getWidth() - this.getGraphicTextGap() * 2 );

    // commit on Enter
    textField.setOnAction( new EventHandler<ActionEvent>()
    {
        @Override
        public void handle( ActionEvent event )
        {
            commitEdit( textField.getText() );
        }
    } );

    textField.focusedProperty().addListener( new ChangeListener<Boolean>()
    {
        @Override
        public void changed( ObservableValue<? extends Boolean> arg0,
                Boolean arg1, Boolean arg2 )
        {
            if ( !arg2 )
            {
                commitEdit( textField.getText() );
            }
        }
    } );

}