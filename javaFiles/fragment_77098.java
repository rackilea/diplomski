public void replaceAllText() {

    Timer timer = new Timer();
    final long DELAY = 300; // milliseconds

    timer.cancel();
    timer = new Timer();
    timer.schedule(
            new TimerTask() {
                @Override
                public void run() {
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String replace = searchFriends.getText().toString();
                            searchFriends.setText(replace);
                            searchFriends.setSelection(searchFriends.getText().length());
                        }
                    });
                }
            },
            DELAY
    );
}