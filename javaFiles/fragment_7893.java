public class documentListener implements DocumentListener //This is a listener
{
    public void changedUpdate(DocumentEvent e){

    }

    public void removeUpdate(DocumentEvent e){
        int lengthMe = e.getDocument().getLength();
        System.out.println(e.getDocument().getText(0,lengthMe));
    }

    public void insertUpdate(DocumentEvent e){
        int lengthMe = e.getDocument().getLength();
        System.out.println(e.getDocument().getText(0,lengthMe));
    }
}