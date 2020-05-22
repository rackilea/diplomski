exebouton.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            mousePressed = true;
            new Thread() {
                public void run() {
                    while (mousePressed) {
                        counter += 1;
                        ecran.setText(ecran.getText() + counter + "\n");
                    }
                }

            }.start();
        }

        public void mouseReleased(MouseEvent e) {
            mousePressed = false;
        }

    });