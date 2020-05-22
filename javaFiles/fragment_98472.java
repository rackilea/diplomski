public void requestToPrint(Client c) {

    setAvailable(false);

    Thread job = new Thread(new Runnable() {
        @Override
        public void run() {

            // The actual print work

            setAvailable(true);
        }
    });

    job.start();
}