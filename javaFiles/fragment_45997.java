long start = System.currentTimeMillis();
while(true){
    try {
        System.out.println(String.valueOf(seconds));
        seconds= (System.currentTimeMillis()-start)/1000;
        Thread.sleep(500);
    } catch (InterruptedException e1) {
        e1.printStackTrace();
    }
}