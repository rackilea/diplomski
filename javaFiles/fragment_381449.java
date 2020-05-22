while(true){
    Thread t = new Thread(new Runnable(){
         public void run() {
            update(); //say it takes 1 min
         }
    });
    t.start();
    render();
}