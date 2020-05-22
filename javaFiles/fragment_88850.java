public class PetService {
    public Object getData() {
        Future<Integer> futureFirstResult = runFirstQuery();
        Future<Integer> futureSecondResult = runSecondQuery();

        Integer firstResult = futureFirstResult.get();
        Integer secondResult = futureSecondResult.get();
    }

    @Async
    public Future<Integer> runFirstQuery() {
        //do query
        return new AsyncResult<>(result);
    }

    @Async
    public Future<Integer> runSecondQuery() {
        //do query
        return new AsyncResult<>(result);
    }
}