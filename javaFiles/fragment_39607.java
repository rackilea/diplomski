textfield.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (textfield.getText().length() == 2) {
                    textfield.setText(textfield.getText() + ":");
                    textfield.setCaretPosition(textfield.getText().length());
                }
            }
        });