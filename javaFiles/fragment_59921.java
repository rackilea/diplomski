final PlayerViewController  mPlayerView = (PlayerViewController) findViewById( R.id.custom_player );

 // Autoplay video
                  mPlayerView.registerJsCallbackReady(new KPlayerJsCallbackReadyListener() {
                      @Override
                      public void jsCallbackReady() {
                          mPlayerView.play();

                      }
                  });