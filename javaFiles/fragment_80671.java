public lightPanel(int room_num) {
    ...
    makeComponents factory = new makeComponents();
    dimPanel1 = factory.DimSlider(1);
    dimmer1 = factory.passBrightnessfromDimSlider();
    ...
}