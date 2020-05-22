class MyThread extends Thread {
    @Override
    public void run() {
        for (int j=0 ; j< 10; j++) {
            System.out.println("working:" + j + ":" + this.getValue());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //CODE I TRIED TO ADD:
    public boolean getValue(){
        return true;
    }
}