//for waiting to complete another job
 synchronized (synchObj) {
            try { synchObj.wait();}
            catch (InterruptedException ie) {

            }
        }

//when job is done and want the execution from where it was stoped
 synchronized (synchObj) {
                            synchObj.notify();
                        }