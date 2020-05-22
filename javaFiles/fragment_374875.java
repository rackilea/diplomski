SwingUtilities.invokeLater(new Runnable(){
        @override
        public void run(){
            mapLabels[x][y].repaint();
        }
    });