@Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                boolean fromUser) {
            int value = mSeekBar.getProgress();
            mSeekBarValue.setText(value); //<-- Error
            //^^When you pass an int value to setText, 
            //android will look for a resource matching that id 
            //but it wont find it because its just an int value 
            //that you're passing not a resource id. 
            SharedPreferences prefs = getSharedPreferences(
                    PublicMacros.SP_NAME, Context.MODE_PRIVATE);
            Editor editor = prefs.edit();
            editor.putInt(PublicMacros.USER_SETTINGS_RADIUS, value);
            editor.commit();

        }
    });