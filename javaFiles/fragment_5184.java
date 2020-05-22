switch (v.getId()) {
      case R.id.button_4:
          resId = R.raw.button_4; 
          mp = MediaPlayer.create(this, resId); 
          mp.start();
          break;
      case R.id.button_5:
      resId = R.raw.button_5;
      mp = MediaPlayer.create(this, resId); 
      mp.start(); 
      break;
    }