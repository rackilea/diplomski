Thread timer = null;
    private void IntSkok(final int noci) {

        // int noci; //how number I want set
        final int POCKROKOV = 5; // steps between n and n+1
        final double[] hodnota = new double[1]; // how much px is one steps
        timer = new Thread() { // new thread
            public void run() {
                Boolean b = true;
                try {
                    do {
                        sleep(50);
                        while (hodnota[0] < (noci * 34)) {
                            hodnota[0] = hodnota[0] + (34.0 / POCKROKOV);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    // TODO Auto-generated method stub
                                    progresInt.prepisBol(hodnota[0]);
                                    progresInt.Aktualizacia();
                                }

                            });
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }

                    } while (b == true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        };
        timer.start();
    }