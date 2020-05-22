public void run() {
        try {
            System.out.println(name + " is off and speeding!");
            for (int i = 1; i < 10; i++) {
                if (needRep) {
                    p.repair(name);
                    needRep = false;
                }
                runLap();
                Thread.yield();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }