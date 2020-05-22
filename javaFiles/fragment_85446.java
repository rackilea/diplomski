try {
        new Thread(new Runnable(){
            public void run() {
                dataManager.loadFromFile("C:/Users/*****PC/Downloads/****.csv");
                EventQueue.invokeLater(new Runnable(){
                    public void run() {
                        layerUI.stop();
                    }
                });
            }
        }).start();
    } catch (Exception e) {
        e.printStackTrace();
    }