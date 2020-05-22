public class CompletionService<V> {

    private List<Future<V>> results;
    private static boolean loop = true;

    public CompletionService(List<Future<V>> results) {
        this.results = results;
    }

    public Future<V> take() {

        Future<V> retval = null;
        int i = -1;

        while (loop) {
            for (i = 0; i < results.size(); i++) {
                if (results.get(i).isDone()) {
                    retval = results.get(i);
                    abortTake();
                    break;
                }
            }
        }

        //remove task only if it is done
        if (i > -1 && results.get(i).isDone()) {
            results.remove(i);
        }
        resetLoop();
        return retval;
    }

    public synchronized void abortTake() {
        loop = false;
    }

    private synchronized void resetLoop() {
        loop = true;
    }

}