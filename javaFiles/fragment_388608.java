catch(IOException e1) {
    handleException(new Runnable() {
        @Override
        public void run() {
            // do something only with this exception
        }
    });
}