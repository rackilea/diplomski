public void runMe(){
    synchronized (str) {
        for (int a : new int[]{1,2,3,4,5}){
            System.out.println(Thread.currentThread().getName());
        }
    }
}