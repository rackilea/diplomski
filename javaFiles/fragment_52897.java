public void run() {
        Exception e;
            try {
                    e = q.take();
                    e.printStackTrace();
            } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
            }
    }