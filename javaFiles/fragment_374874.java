SwingUtilities.invokeLater(new Runnable(){
        @override
        public void run(){
            panel.validate();
            panel.repaint();
            pane.validate();
        }
    });