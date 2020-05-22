while(cp.getMove() == null) {
        try {
            synchronized(cp) {
                cp.wait();
            }
        } catch (InterruptedException e) {}
    }