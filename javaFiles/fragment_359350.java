public void start() {

        for (Ball ball: ballList) {

            Thread t;
            t = new Thread(this);
            t.start();

        } // end for

    } // end start