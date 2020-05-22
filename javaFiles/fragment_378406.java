public class SelfLink<MODEL,MESSAGE extends LinkedMessage> implements ToMessageOperation<MODEL, MESSAGE> {


    @Override
    public void run(MODEL object, MESSAGE linkedMessage) throws Exception {

        linkedMessage.linkme();
    }
}

public <MODEL,MESSAGE extends LinkedMessage> SelfLink<MODEL, MESSAGE> selfLink() {

    return null;
}