public static void renewTimer() {
            if (CLIENT_SIDE_TIMER != null) {
                CLIENT_SIDE_TIMER.cancel();
                SessionFactory.getClientInstance().put(
                        SesisonKey.SESSION_EXPIRED, false);
                //CLIENT_SIDE_TIMER.schedule(250 * 60 * 20);
                //1 Minute = 60000 Milliseconds
                CLIENT_SIDE_TIMER.schedule(60000 * 2);
            }
        }