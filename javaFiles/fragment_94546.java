PropertyChangeListener propertyChangeListener = new PropertyChangeListener()     {
        public void propertyChange(PropertyChangeEvent evt) {
            JInternalFrame[] jInternalFrame=desktop.getAllFrames(); //desktop is JDesktopPane
            if(interFrame.isMaximum()){
            System.out.println("My window Maximised");
            }};

      interFrame.addPropertyChangeListener(propertyChangeListener );