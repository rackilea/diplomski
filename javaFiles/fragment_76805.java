public void run() {
        OBDcmds();

        ModuleVoltageCommand voltageCommand = new ModuleVoltageCommand();
        //TextView textView = (TextView) findViewById(R.id.textView);

        while (!Thread.currentThread().isInterrupted()) {
            try {
                voltageCommand.run(mmInStream, mmOutStream);
                Log.d("Log", "Voltage:" + voltageCommand.getFormattedResult());
                guiHandler(Constants.VOLTAGE_STATUS, 0, voltageCommand.getFormattedResult())
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }