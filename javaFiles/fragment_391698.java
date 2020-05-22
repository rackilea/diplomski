private void addItem() {
    final String newString = new String("sampleText");
    s.add(newString);
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // inserting new item to database
            b.insert(newString);
        }
    };
    new Thread(runnable).start();
    listener.stateChanged(new ChangeEvent(this));
}