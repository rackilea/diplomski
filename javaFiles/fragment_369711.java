Serial serial;
boolean serialInited;

void setup () {
    initSerial();
}

void draw () {
    if (serialInited) {
        // serial is up and running
        try {
            byte b = serial.read();
            // fun with serial here...
        } catch (RuntimeException e) {
            // serial port closed :(
            serialInited = false;
        }
    } else {
        // serial port is not available. bang on it until it is.
        initSerial();
    }
}

void initSerial () {
    try {
        serial = new Serial(this, Serial.list()[0], BAUD_RATE);
        serialInited = true;
    } catch (RuntimeException e) {
        if (e.getMessage().contains("<init>")) {
            System.out.println("port in use, trying again later...");
            serialInited = false;
        }
    }
}