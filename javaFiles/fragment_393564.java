public class ResultWrapper implements Serializable {
    private String result = "working"; //String, since the resultService.result() is returning Future<String>
    private transient Future future; //transient as it is not serializable.

    public String getResult() {
        if (future != null && future.isDone()) {
            result = future.get();
            //Once the future is done, call the session.setAttribute(...) so that value of result field is replicated across the JVM nodes.
        }
        return result;
     }
}