protected void movement(){

    final int delay = delay();

    h.postDelayed(new Runnable() {
        public void run() {
            tgc.setY(tgc.getY() + 8);
            tbc.setY(tbc.getY() + 8);
            trc.setY(trc.getY() + 8);
            tyc.setY(tyc.getY() + 8);

            if (tbc.getY() > yc.getY()){
                 gameLost();
            }
            h.postDelayed(this, delay);
        }
    },delay);

    }
    }