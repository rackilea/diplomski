// so it already works
public void incChannel(int channel) {
    if (status.equalsIgnoreCase("ON")) {
        channelNumber = ++channel;
    } else if (status.equalsIgnoreCase("OFF")) {
        System.out.println("Error TV is off");
    }