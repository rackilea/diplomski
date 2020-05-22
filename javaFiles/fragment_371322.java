public static class MainPanel extends JPanel{
    private JTextArea textArea;

    public MainPanel() {
        this.setLayout(new BorderLayout());
        this.textArea = new JTextArea();// you can use constructor to set Text but I like use method "setText".
        this.textArea.addKeyListener(new keyHandler());
        this.textArea.setText("Welcome\r\nSelect an option. 1.) New register. 2.) New input. 3.) Exit.\r\n");
        this.textArea.setCaretPosition(this.textArea.getText().length());// move caret to last
        this.add(this.textArea, BorderLayout.CENTER);
    }

    public void addText(String text) {textArea.setText(textArea.getText() + "\r\n" + text +"\r\n");}

    public class keyHandler extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e) {
            switch(e.getKeyCode()){
            case KeyEvent.VK_1 : addText("New register"); break;
            case KeyEvent.VK_2 : addText("New input"); break;
            case KeyEvent.VK_3 : addText("Exit"); break;
            }
        }
    }
}