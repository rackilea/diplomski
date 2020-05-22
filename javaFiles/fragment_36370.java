public interface PinChangeListener {
    public void pinChanged();
}

public class CreditCard {
    public PinChangeListener pinChangeListener;

    private int pin;

    public changePin(int pin) {
        this.pin = pin;
        if (pinChangeListener != null) {
            pinChangeListener.pinChanged();
        }
    }
}