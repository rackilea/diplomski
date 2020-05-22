synchronized (someObject) {
    if (!finished) {
        finished = true;
        System.out.println("Finished !!");
        timer.cancel(); 
    }
}