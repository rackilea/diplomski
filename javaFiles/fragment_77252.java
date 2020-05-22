final CyclicBarrier cb = new CyclicBarrier(this.maxDownload, new Runnable(){
    @Override
    public void run(){
        System.out.println("All download are finished");
        //Mergear cuando se termina
        //Borrar cuando se termina
    }

});