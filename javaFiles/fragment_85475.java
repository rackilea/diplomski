KeyAdapter event=  new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                //do something
            }

            public void keyTyped(KeyEvent e) {
                // TODO: Do something for the keyTyped event
            }

            public void keyPressed(KeyEvent e) {
                // TODO: Do something for the keyPressed event
            }
        });


txtField1.addKeyListener(event);
txtField2.addKeyListener(event);
-----