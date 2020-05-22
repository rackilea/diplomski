@Override
 protected void onActivityResult(final int requestCode, final int resultCode, final Intent intent)
 {
     if (resultCode == Activity.RESULT_OK && requestCode == 5)
     {
          Uri uri = intent.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);

          if (uri != null)
          {
              this.chosenRingtone = uri.toString();
          }
          else
          {
              this.chosenRingtone = null;
          }
      }            
  }