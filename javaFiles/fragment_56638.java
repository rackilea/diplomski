import java.util.concurrent.Semaphore;
private Semaphore sem = new Semaphore(NUM_MAX_CONCURRENT);

// Spawner
while(!done) {

    sem.acquire(); // added by corsiKa

    spawnNewProcess(nextId, parameters);

    myListener.listenFor(nextId);

    nextId ++;
}

// listener
while(!done) {
    for (int id : toListenFor) {
        if (resultMap.contains(id)) {
            result = resultMap.get(id);

            toListenFor.remove(id);
            sem.release(); // added by corsiKa
            process(result);
        }
    }
}