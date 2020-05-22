class Thread2 implements Runnable {
    private DifferentThreadJavaFXMinimal d;

    Thread2(DifferentThreadJavaFXMinimal dt){
        d=dt;
    }

    @Override
    public void run() {
        for (int i=0;i<4;i++) {
            final int value = i ;
            Platform.runLater(() -> d.addElement(value));
            // presumably in real life some kind of blocking code here....
        }
        System.out.println("Hahó");
    }

}