room.getLightByName("Tv 1").get().turnOn();

    Timer timer = new Timer();

    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            room.getLightByName("Tv 2").get().turnOn();
        }
    }, 3000L);

    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            room.getLightByName("Tv 1").get().turnOff();
            room.getLightByName("Tv 2").get().turnOff();
        }
    }, 11000L);