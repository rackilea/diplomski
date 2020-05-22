public class IOIOSimpleApp extends IOIOActivity {

protected static final float FAULT_DISPLAY_DURATION = 10; // seconds

private TextView boost;
private TextView fuelpressure;
private TextView ioioStatusText;
private TextView internalText;
private TextView thermocoupleText;
private TextView faultsText;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    boost = (TextView) findViewById(R.id.boost);
    fuelpressure = (TextView) findViewById(R.id.fuelpressure);
    ioioStatusText   = (TextView) findViewById(R.id.ioio_status);
    internalText     = (TextView) findViewById(R.id.internal);
    thermocoupleText = (TextView) findViewById(R.id.thermocouple);
    faultsText       = (TextView) findViewById(R.id.faults);


    //components in main activity
    ioioStatusText   = (TextView) findViewById(R.id.ioio_status);
    internalText     = (TextView) findViewById(R.id.internal);
    thermocoupleText = (TextView) findViewById(R.id.thermocouple);
    faultsText       = (TextView) findViewById(R.id.faults);
    boost            = (TextView) findViewById(R.id.boost);
    fuelpressure     = (TextView) findViewById(R.id.fuelpressure);

    enableUi(false);
}

class Looper extends BaseIOIOLooper {
    private AnalogInput boost, fuelpressure;

    @Override
    public void setup() throws ConnectionLostException {
        boost = ioio_.openAnalogInput(45);
        fuelpressure = ioio_.openAnalogInput(42);
        enableUi(true);
    }

    @Override
    public void loop() throws ConnectionLostException, InterruptedException {
        setNumber1(38.314 * ((boost.getVoltage() - 0.27)));
        setNumber2(38.314 * ((fuelpressure.getVoltage() - 0.27)));
        Thread.sleep(200);
    }

    @Override
    public void disconnected() {
        enableUi(false);
    }
}

@Override
protected IOIOLooper createIOIOLooper() {
    int sdoPin = 1; // DO
    int sdaPin = 29; // we do not use this pin but the IOIOLib requires we specify it, so we pick an unused pin
    int sclPin = 2; // CLK
    int csPin  = 3; // CS
    SpiMaster.Rate rate = SpiMaster.Rate.RATE_31K;
    final MAX31855 max31855 = new MAX31855(sdoPin, sdaPin, sclPin, csPin, rate);
    max31855.setListener(new MAX31855.MAX31855Listener() {
        private long faultTime;

        @Override
        public void onData(float internal, float thermocouple) {
            updateTextView(internalText, "Internal = " + internal + " C");
            updateTextView(thermocoupleText, thermocouple + " C");

            float secondsSinceFault = (System.nanoTime() - faultTime) / 1000000000.0f;
            if (secondsSinceFault > FAULT_DISPLAY_DURATION) {
                updateTextView(faultsText, "Faults = ");
            }
        }

        @Override
        public void onFault(byte f) {
            List<String> faults = new ArrayList<String>();

            if ((f & MAX31855.FAULT_OPEN_CIRCUIT_BIT) == MAX31855.FAULT_OPEN_CIRCUIT_BIT)
                faults.add("Open Circuit");
            if ((f & MAX31855.FAULT_SHORT_TO_GND_BIT) == MAX31855.FAULT_SHORT_TO_GND_BIT)
                faults.add("Short To GND");
            if ((f & MAX31855.FAULT_SHORT_TO_VCC_BIT) == MAX31855.FAULT_SHORT_TO_VCC_BIT)
                faults.add("Short To VCC");

            boolean first = true;
            String text = "Faults = ";
            for (String fault : faults) {
                if (!first)
                    text += ", ";
                text += fault;
            }
            if (faults.size() > 0) {
                faultTime = System.nanoTime();
            }

            updateTextView(faultsText, text);
        }
    });
    return new IOIOSimpleApp.DeviceLooper(max31855);
}
private void enableUi(final boolean enable) {
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            //seekBar_.setEnabled(enable);
            //toggleButton_.setEnabled(enable);
        }
    });
}

private void setNumber1(double f) {
    final String str = String.format("%.0f", f);
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            boost.setText(str);
        }
    });
}

private void setNumber2(double f) {
    final String str = String.format("%.0f", f);
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            fuelpressure.setText(str);
        }
    });
}
private void updateTextView(final TextView textView, final String text) {
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            textView.setText(text);
        }
    });
}


/**
 * This is the thread on which all the IOIO activity happens. It will be run
 * every time the application is resumed and aborted when it is paused. The
 * method setup() will be called right after a connection with the IOIO has
 * been established (which might happen several times!). Then, loop() will
 * be called repetitively until the IOIO gets disconnected.
 */
class DeviceLooper extends BaseIOIOLooper {

    private IOIOLooper device;

    public DeviceLooper(IOIOLooper device) {
        this.device = device;
    }

    @Override
    public void setup() throws ConnectionLostException, InterruptedException {
        device.setup(ioio_);
        updateTextView(ioioStatusText, "IOIO Connected");
    }

    @Override
    public void loop() throws ConnectionLostException, InterruptedException {
        device.loop();
    }

    @Override
    public void disconnected() {
        device.disconnected();
        updateTextView(ioioStatusText, "IOIO Disconnected");
    }

    @Override
    public void incompatible() {
        updateTextView(ioioStatusText, "IOIO Incompatible");
    }

} }