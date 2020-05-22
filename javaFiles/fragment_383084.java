private class MyDocumentListener implements DocumentListener
{
    public void changedUpdate(DocumentEvent e){
        //Do nothing
    }
    public void insertUpdate(DocumentEvent e){
        //Do things when text are inserted
    }
    public void removeUpdate(DocumentEvent e){
        //Do things when text are deleted
    }
}