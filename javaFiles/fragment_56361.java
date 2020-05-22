int[] myAudio = {R.raw.audio1, R.raw.audio2, R.raw.audio3};
int mTrackFinish = 0;
MediaPlayer mp = MediaPlayer.create(this, myAudio[0]);
mp.setOnCompletionListener(new OnCompletionListener() 
{
@Override
public void onCompletion(MediaPlayer mp)
{
 mTrackFinish++;
 mp.reset();
 if(mTrackFinish < myAudio.length)
        // play some audio from list
    else
      mTrackFinish=0;
      mp.release();
      mp = null;  // either set counter to 0 and start again or call end of list

}
});
mp.start();