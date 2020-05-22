player.setOnCompletionListener(new OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            // TODO Auto-generated method stub
            mp.stop();
            mp.release();
            if (i < numberOfFiles) {
                i++;
 String path=Environment.getExternalStorageDirectory() .getAbsolutePath()+ "/android"+"/"+i+".3gp";
           playAudio(path);
            }
            else i=0;
        }