new Thread() {

        @Override
        public void run() {
            try {
                Thread.sleep(Integer.parseInt(delayField.getText()) * 1000);
                System.out.println("Hello!");
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
    }.start();