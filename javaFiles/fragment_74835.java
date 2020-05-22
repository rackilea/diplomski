KeyEvent keyEvent  = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
  if (keyEvent != null) {
      if (event.getAction() == KeyEvent.ACTION_UP)
      {
           switch(keyEvent.getKeyCode()) {
           case KeyEvent.KEYCODE_MEDIA_PLAY:
                  .... &c.
            }
      }
    }