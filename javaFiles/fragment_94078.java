try {
    this.manageException(new Runnable() {
        @Override
        public void run() {
            // Do something
        }
    });
}
catch (MyCustomException mce) {
    int code = mce.getCode();
}