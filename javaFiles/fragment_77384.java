public Janus(){
        JanusUI gui = new JanusUI();
        gui.setVisible(true);
        String os = detectOS();
        gui.setOSText(os);

    }