@Override
     public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            try {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }
            catch (Exception e) {
                 Toast.makeText(mContext, "Error)", Toast.LENGTH_SHORT).show();
            }

            show(sDefaultTimeout, fromUser);
      }

public void show(int timeout, boolean fromUser) {
        if (!mShowing && mAnchor != null) {

            FrameLayout.LayoutParams tlp = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    Gravity.RIGHT | Gravity.TOP
            );

            mAnchor.addView(this, tlp);
            mShowing = true;
        }
        if(fromUser)// prevent infinitive recursive
             updateCurrentSoundValue();

        Message msg = mHandler.obtainMessage(FADE_OUT);
        if (timeout != 0) {
            mHandler.removeMessages(FADE_OUT);
            mHandler.sendMessageDelayed(msg, timeout);
        }
 }