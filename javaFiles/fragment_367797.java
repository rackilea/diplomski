public class PhoneImpl implements Phone 

    @Override
    public void call(String number, PhoneListener listener) {
        // perform the phone call
        // chat
        // tell the listener that the call is complete
        listener.callEnded(this);
    }
}