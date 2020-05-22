class MvcController {
    private MvcModel model;
    private MvcView view;

    public MvcController(MvcModel model, MvcView view) {
        this.model = model;
        this.view = view;

        model.addPropertyChangeListener(MvcModel.BATTERY, new BatteryListener());
        model.addPropertyChangeListener(MvcModel.SPEED, new SpeedListener());

        view.getSpeedSlider().addChangeListener(chngEvent -> {
            int value = view.getSpeedSlider().getValue();
            model.setSpeed(value);
        });

        view.getBatterySlider().addChangeListener(chngEvent -> {
            int value = view.getBatterySlider().getValue();
            model.setBatteryPercentage(value);
        });
    }

    public void init() {
        view.getSpeedSlider().setValue(10);
        view.getBatterySlider().setValue(100);

        model.setSpeed(10);
        model.setBatteryPercentage(100);
    }

    class SpeedListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            float speed = model.getSpeed();
            view.setSpeed(speed);
        }
    }

    class BatteryListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            int batteryPercent = model.getBatteryPercentage();
            view.setBatteryPercent(batteryPercent);
        }
    }    
}