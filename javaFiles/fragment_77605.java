private void startServiceTimer() {
    timer.schedule(new TimerTask() {
        public void run() {

            // send sms
            sendSMS();
        }

    // } from here
    }, delay_interval, period);
} <-- to here