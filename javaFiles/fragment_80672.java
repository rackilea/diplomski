// can you spot the error?

public lightPanel(int room_num) {
    ...
    makeComponents factory = new makeComponents();
    dimmer1 = factory.passBrightnessfromDimSlider();
    dimPanel1 = factory.DimSlider(1);
    ...
}