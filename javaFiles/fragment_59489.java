private void printThreadName(){
    synchronized (lock) {
        while (!("Thread-"+ activeThread).equals(this.getName())) {
            try{
                lock.wait();
            }catch (InterruptedException e){
                System.out.println(this.getName()+" was interrupted!");
            }
        }
        System.out.println(this.getName());
        activeThread = (activeThread + 1) % N;
        lock.notifyAll();
    }
}