public static void main(String... args){

    ExecutorService pool = Executors.newFixedThreadPool(4); //nbr of active threads

    File dir = new File("/dir/");
    for(File f : dir.listFiles())
    pool.submit(new Runnable() {
         public void run(){
             processImage(f);
        }
    } 
}