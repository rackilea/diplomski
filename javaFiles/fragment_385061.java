enum Check {

    IntentReady {

                @Override
                boolean check(CompoundButton buttonView, boolean wifi_state) {
                    return buttonView.getId() == R.id.switch_ros & buttonView.isChecked() & wifi_state;
                }

                @Override
                void apply(Switch sr, Switch srs) {
                    Toast.makeText(this, "ros intent ready", Toast.LENGTH_SHORT).show();
                }

            },
    WIFIBad {

                @Override
                boolean check(CompoundButton buttonView, boolean wifi_state) {
                    return buttonView.getId() == R.id.switch_ros & buttonView.isChecked() & !wifi_state;
                }

                @Override
                void apply(Switch sr, Switch srs) {
                    Toast.makeText(this, "log: wifi bad", Toast.LENGTH_SHORT).show();
                    sr.setChecked(false);
                }

            };

    abstract boolean check(CompoundButton buttonView, boolean wifi_state);

    abstract void apply(Switch sr, Switch srs);
}

public void onCheckedChangedNew(CompoundButton buttonView, boolean isChecked) {
    Switch sr = (Switch) findViewById(R.id.switch_ros);
    Switch srs = (Switch) findViewById(R.id.switch_ros_stream);
    boolean wifi_state = isConnected(this);
    for ( Check c : Check.values()) {
        if ( c.check(buttonView, wifi_state)) {
            c.apply(sr, srs);
        }
    }
}