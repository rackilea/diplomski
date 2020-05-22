@Override
    public void actionPerformed(ActionEvent arg0) {

        Thread t = new Thread("my non EDT thread") {
            public void run() {
                //my work
                new GameInitializer(userName, player, Constants.BLIND_STRUCTURE_FILES.get(blindStructure), handState);
            }

        };
        t.start();
    }