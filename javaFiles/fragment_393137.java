for (int num: number) {
    WorkerThread worker = new WorkerThread(num); //worker.y = num
    for (int  anotherNum : anotherNumbers) {
        worker.x = anotherNum; //we assign x here
        executor.execute(worker); //You call by the object, not by its method
    }
}