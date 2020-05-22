Thread t = new Thread() {
        @Override
        public void run() {
            super.run();
            try {
            voice = initializeTTS(); // a func to initialize TTS lib.
            voice.speak("Hello world");
            // do whatever you want to do from here only.
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
};
t.start();