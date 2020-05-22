public class CompositeException extends Exception {
    private List<Exception> exceptions = new ArrayList<Exception>();
    public List<Exception> getExceptions() {
        return exceptions;
    }
}