textField.addKeyListener(new KeyListener() {

        int codeDelete = KeyEvent.getExtendedKeyCodeForChar(KeyEvent.VK_DELETE);
        int codeBackSpace = KeyEvent.getExtendedKeyCodeForChar(KeyEvent.VK_BACK_SPACE);

        @Override
        public void keyTyped(KeyEvent e) {

            char keyChar = e.getKeyChar();

            if (textField.getText().length() == 0) {
                textField.setText("0");
            }
            else if (textField.getText().equals("0") && keyChar != codeDelete && keyChar != codeBackSpace) {
                textField.setText(String.valueOf(e.getKeyChar()));
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    });