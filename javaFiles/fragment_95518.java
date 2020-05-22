fShirts.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("hide menu");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("show menu");
        }
    });