@Override
public void startEdit()
{
    if ( !isEmpty() )
    {
        super.startEdit();
        createTextField();
        setText( null );
        setGraphic( textField );
        textField.requestFocus();
        // textField.selectAll(); commenting out this because
        // JavaFX confuses the caret position described in the comment
        // as OP has observed. Seems to be a bug.
    }
}