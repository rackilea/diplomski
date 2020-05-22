@Override
            public void onClick(View v)
            {
                if (mPhoneIsSilent) 
                {   //set to normal mode
                    mAudioManager
                    .setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    mPhoneIsSilent = false;
                    ((Button)v).setText("Turn On");
                }
                else
                {
                    mAudioManager
                    .setRingerMode(AudioManager.RINGER_MODE_SILENT);
                    mPhoneIsSilent = true;
                    ((Button)v).setText("Turn Off");
                }