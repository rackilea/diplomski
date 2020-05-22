GpioController gpio = GpioFactory.getInstance();
GpioPinDigitalMultipurpose led = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_07, PinMode.DIGITAL_INPUT);

// read state

led.setMode(PinMode.DIGITAL_OUTPUT);

// write state