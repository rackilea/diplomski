public void produces() throws InterruptedException {

    int value = 0;
    while (true){
        semaphore.acquire();
        if(integerList.size() != 10 ) {
            integerList.add(value++);
        }
        semaphore.release();
    }

}

public void consumes() throws InterruptedException {
    Thread.sleep(100);
    semaphore.acquire();
    while (true){
        Integer take = integerList.removeFirst();
        System.out.println("Size of the BlockingQueue is : "+ integerList.size()+" and the value consumed is :"+take);
        Thread.sleep(100);
        semaphore.release();
    }
}