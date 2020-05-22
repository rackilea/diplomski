public abstract class Controller {

    private Result deleteHelper(Long id, boolean useTransaction) {
        // do something and return result
    }

    public Result delete(Long id) {
        return deleteHelper(id, true);
    }
    public Result delete(Long id, boolean useTransaction) {
        return deleteHelper(id, useTransaction);
    }
}