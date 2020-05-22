private void downloadAttachments(final List<String> ftIdList) {
    final int size = ftIdList.size();

    Timer timer = new Timer() {

        private int counter = 0;

        @Override
        public void run() {
        if (counter == size) {
          cancel();
          return;
        }
        String url = ftIdList.get(counter);
        String winName = "win" + counter;
        Window.open(url, winName, "");
        counter++;
        }
    };
    timer.scheduleRepeating(2000);
}