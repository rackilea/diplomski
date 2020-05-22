while (true) {
    try {
        submitJob(Manager.queue.take()); //or do something else with the Job
        //your code here, then remove the break
        break;
    } catch (InterruptedException ex) {
        //usually no need to do anything, simply live on unless you
        //caused that
    }
}
//or your code here, then you need an surrounding while and the break