AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050,1024,0);

    double threshold = 8;
    double sensitivity = 20;

    PercussionOnsetDetector mPercussionDetector = new PercussionOnsetDetector(22050, 1024,
            new OnsetHandler() {

                @Override
                public void handleOnset(double time, double salience) {
                    Log.d(TAG, "Clap detected!");
                }
            }, sensitivity, threshold);

    mDispatcher.addAudioProcessor(mPercussionDetector);
    new Thread(mDispatcher,"Audio Dispatcher").start();