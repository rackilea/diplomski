if (getActivity() != null) {
    Thread thread = new Thread() {
        @Override
        public void run() {
            float i;
            try {
                for (i = 0; i <= 100; i++) {
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            getData();
                        }
                    });
                    sleep(6000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    thread.start();
}