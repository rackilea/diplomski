public class VerifyNoMoreInteractionsRule extends TestWatcher {

    private final List<Object> mocks = new ArrayList<>();

    public void add(Object mock){
        mocks.add(mock);
    }

    @Override
    protected void succeeded(Description description) {
        verifyNoMoreInteractions(mocks.toArray());
    }

}