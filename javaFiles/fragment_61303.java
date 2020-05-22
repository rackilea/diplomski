JLabel lblFileLink = new JLabel("Audio File Title");

// To indicate the the link is clickable
lblFileLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

lblFileLink.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                Desktop.getDesktop().open(
                        new File("AUDIO FILE PATH"));
            } catch (IOException e1) {

                e1.printStackTrace();
            }
        }
    });