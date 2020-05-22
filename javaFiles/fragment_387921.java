final Handler handler = new Handler();
new Thread(new Runnable() {
    @Override
    public void run() {
        for (int jogada = 1; jogada <= 50; jogada++) {
            for (int contador = 0; contador < jogada; contador++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        btPedra[sequencia[contador]].setBackgroundResource(imagensHover[sequencia[contador]]);
                    }
                });
            }
        }
    }
}).start();