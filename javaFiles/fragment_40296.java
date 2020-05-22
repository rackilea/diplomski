class ImagePanel extends JPanel
    {

        public ImagePanel()
        {
            setBackground(Color.BLACK);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(smileyFace.getImage(), xCoord, yCoord, this);
        }

        @Override
        public void setBackground(Color bg) {
            super.setBackground(bg); //To change body of generated methods, choose Tools | Templates.
        }


    }