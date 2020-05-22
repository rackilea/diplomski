public void onBrowserEvent( com.google.gwt.cell.client.Cell.Context context, Element parent, String value, NativeEvent event, ValueUpdater<String> valueUpdater )
    {       
        if ( "keypress".equals( event.getType() ) )
        {
            int charCode = event.getCharCode();
            if ( !Character.isDigit( ( char ) charCode ) )
            {
              System.out.println("This is a digit!!!");
            }
        }
        super.onBrowserEvent( context, parent, value, event, valueUpdater );
    }