snackbar.addCallback(new Snackbar.Callback() {

        @Override
        public void onDismissed(Snackbar snackbar, int event) {
            if (event == DISMISS_EVENT_MANUAL) {
                // Some work to be done.
                activity.finish()
            }
        }