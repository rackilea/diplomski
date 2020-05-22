// custom way for finalization of the threads
     boolean finish = false; // initially all non finised 
     while(!finish) {
            for (int i = 0; i < 2; i++) {
                if (threads[i].getState() != status[i]) {
                    status[i] = threads[i].getState();
                    }
                }
            finish = true;
            for (int i = 0; i < 2; i++) {
            finish = finish && (threads[i].getState() ==
                                State.TERMINATED);
                }
 }