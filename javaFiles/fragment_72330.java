public class ExtendedAsyncCallback<T> implements AsyncCallback<T> {

    private static int activeCallbacks;

    public ExtendedAsyncCallback() {
        // here I block the UI and show a nice spinner
        activeCallbacks++;
    }

    @Override
    public void onFailure(Throwable caught) {
        activeCallbacks--;
        // show an error message depending on exception
    }

    @Override
    public void onSuccess(T result) {
        activeCallbacks--;
        if (activeCallbacks == 0) {
            // here I hide my spinner
        }
        execute(result);
    }

    public void execute(T result) {
        // I use this method in presenters instead of 'onSuccess'
    }