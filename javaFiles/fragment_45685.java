public class CallableA extends AbstractCallable {
    public CallableA(CallableData data) {
        super(data);
    }

    @Override
    public Boolean call() throws Exception {
        CallableData d = this.getData();

        //perform CallableA logic

        return null;
    }
}