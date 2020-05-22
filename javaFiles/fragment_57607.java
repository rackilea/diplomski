@Override
public void keyPressed(KeyEvent evt) {
    // TODO Auto-generated method stub
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        try {
            int end = myTextArea.getCaretPosition();
            int row = myTextArea.getLineOfOffset(end);
            int column = end - myTextArea.getLineStartOffset(row);
            int begin = end - column;
            int length = end - begin;

            System.out.println(myTextArea.getText(begin, length));

        } catch (BadLocationException ex) {
            System.out.println(ex.getMessage());
        }
        myTextArea.append("\n" + ">>>" + " " + "matlab's response");
    }

}