public synchronized boolean isComplete(){
        Iterator<Future<?>> itr = futures.iterator();
        while (itr.hasNext()) {
            if (itr.next().isDone()) itr.remove();
            else return false;
        }
        return true;
    }