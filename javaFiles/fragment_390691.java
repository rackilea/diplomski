if (progressDialog.isShowing()) {

      Runnable progressRunnable = new Runnable() {
        @Override
        public void run() {
          progressDialog.cancel();
          myVideoView.seekTo(position);
          if (position == 0) {
            myVideoView.start();
          } else {
            myVideoView.pause();
          }
        }
      };
      Handler pdCanceller = new Handler();
      pdCanceller.postDelayed(progressRunnable, 3000);
    }