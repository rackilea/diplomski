textfield.addKeyListener(new KeyAdapter() {
        boolean ctrlPressed = false;
        boolean cPressed = false;

        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
            case KeyEvent.VK_C:
                cPressed=true;

                break;
            case KeyEvent.VK_CONTROL:
                ctrlPressed=true;
                break;
            }

            if(ctrlPressed && cPressed) {
                System.out.println("Blocked CTRl+C");
                e.consume();// Stop the event from propagating.
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch(e.getKeyCode()) {
            case KeyEvent.VK_C:
                cPressed=false;

                break;
            case KeyEvent.VK_CONTROL:
                ctrlPressed=false;
                break;
            }

            if(ctrlPressed && cPressed) {
                System.out.println("Blocked CTRl+C");
                e.consume();// Stop the event from propagating.
            }
        }
    });