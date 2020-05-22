mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
@Override
public void onCompletion(MediaPlayer mp) 
{
   if(currentPosition<sourceArray.size())
   {
        mediaPlayer.reset();
       /* load the new source */
       mediaPlayer.setDataSource(sourceArray[position]);
       /* Prepare the mediaplayer */
       mediaPlayer.prepare();
       /* start */
       mediaPlayer.start();
   }
   else
   {
       /* release mediaplayer */
       mediaPlayer.release();
   }
 }