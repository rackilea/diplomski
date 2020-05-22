if(builder.toString().contains("ABCDEF_AUDIO"))
    {
        layoutAudio.setVisibility(View.VISIBLE);    
        final MediaPlayer mp;
        final Handler durationHandler = new Handler();          
        view.audioSeekBar.setClickable(true);
        view.audioSeekBar.setVisibility(View.VISIBLE);
        view.imgView1.setVisibility(View.GONE);
        view.iconImageNvideo.setVisibility(View.GONE);
        view.textView.setVisibility(View.GONE);     
        String path = messageItem.getText();
        //System.out.println("AUDIO path : " + path);
        File PathDirectoryCHECK= new File(Environment.getExternalStorageDirectory().toString() + "/ABCDEF/ABCDEF_AUDIO");  
        final File PathofAudioCHECK = new File(PathDirectoryCHECK.getPath() + File.separator + path);
        //System.out.println("PathofAudioCHECK : " + PathofAudioCHECK); 
        mp = new MediaPlayer();    
        mp.setLooping(false);
                  final Runnable runnableAudio = new Runnable() 
                     {
                            public void run() 
                            {                                                       
                                timeElapsed = mp.getCurrentPosition();
                                view.audioSeekBar.setProgress((int) timeElapsed);
                                finalTime = mp.getDuration();
                                double timeRemaining = finalTime - timeElapsed;
                                view.audioDuration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining), TimeUnit.MILLISECONDS.toSeconds((long) timeRemaining) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining))));
                                durationHandler.postDelayed(this, 100);                                                 
                            }
                    };    
        try {               
                if(PathofAudioCHECK.isFile())
                {
                    final Uri audioUri=Uri.fromFile(PathofAudioCHECK);                      
                    mp.setDataSource(activity,audioUri);    
                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);                           
                    mp.prepare();
                    finalTime = mp.getDuration();
                    view.audioSeekBar.setMax((int) finalTime);
                    int duration = mp.getDuration();
                    if(duration==-1)
                        view.audioDuration.setText("");
                    else
                        view.audioDuration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((int) duration), TimeUnit.MILLISECONDS.toSeconds((int) duration)));

                    view.audioSeekBar.setOnTouchListener(new OnTouchListener() 
                    {   
                        @SuppressLint("ClickableViewAccessibility") @Override
                        public boolean onTouch(View v, MotionEvent event) 
                        {   
                            if(mp.isPlaying())
                            {
                                SeekBar sb = (SeekBar)v;
                                mp.seekTo(sb.getProgress());
                            }
                            return false;
                        }
                    });                 
                    view.imgAudioPlay.setOnClickListener(new View.OnClickListener()
                    {
                        public void onClick(View v)
                        {   
                            try
                            {
                                if(isPlaying && !mp.isPlaying() && mp!=null)
                                {
                                    mpG.pause();                                
                                }
                                if(mp!=null && mp.isPlaying())
                                {
                                    mp.pause();
                                    isPlaying = false;                      

                                }
                                else if(!mp.isPlaying())
                                {
                                    if(mp!=null)
                                    {

                                        mpG = mp;
                                        isPlaying = true;
                                        vhG = view;
                                        mp.start(); 

                                        timeElapsed = mp.getCurrentPosition();
                                        view.audioSeekBar.setProgress((int) timeElapsed);                                            
                                         durationHandler.postDelayed(runnableAudio, 100);

                                         mp.setOnCompletionListener(new OnCompletionListener() {                                                
                                            @Override
                                            public void onCompletion(MediaPlayer mp) {                                          
                                                view.audioSeekBar.setProgress(0);
                                                mp.seekTo(0);
                                                mp.reset();
                                                mp.stop();                                          
                                                isPlaying = false;
                                                mp.release();
                                                durationHandler.removeCallbacks(runnableAudio);

                                                notifyDataSetChanged();
                                            }
                                        });
                                         mp.setOnSeekCompleteListener(new OnSeekCompleteListener()
                                            {               
                                                public void onSeekComplete(MediaPlayer mp) {                                                
    //                                              System.out.println("Audio : 6");
                                                    view.audioSeekBar.setProgress(0);
                                                    mp.reset();
                                                    mp.stop();  
                                                    isPlaying = false;
                                                    mp.release();       

                                                    durationHandler.removeCallbacks(runnableAudio);
                                                    notifyDataSetChanged();
                                                }
                                            });
                            }
                                    }

                        }
                        catch (IllegalStateException e) {
                            e.printStackTrace();
                        } 
                        }});                            
                }
                else if(!PathofAudioCHECK.isFile() || PathofAudioCHECK==null)
                {
                            if(incoming)
                            {
                                if(counterDOWNLOADfromSERVER!=1)
                                {
                                    counterDOWNLOADfromSERVER=1;
                                    String[] parts = path.split("\\."); // String array, each element is text between dots
                                    String beforeFirstDot = parts[0];
                                    String pathSubStr=beforeFirstDot.substring(13);             
                                //  System.out.println("BUILDER name ID : " + pathSubStr);                  
                                    String url = configurationsFileTransfer.FILE_URL_TRANSFER + pathSubStr;
                                    new HttpAsyncTaskforAudio().execute(url);
                                    //System.out.println("AUDIo received  : " + get_newPathofAUDIOreceived());
                                    try
                                    {                               
                                    if(get_newPathofAUDIOreceived().exists() || get_newPathofAUDIOreceived().isFile() || get_newPathofAUDIOreceived()!=null)
                                    {                
                                        final Uri audioUri=Uri.fromFile(get_newPathofAUDIOreceived());
                                        mp.setDataSource(activity,audioUri);    
                                        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                        mp.prepare();
                                        finalTime = mp.getDuration();
                                        view.audioSeekBar.setMax((int) finalTime);
                                        view.audioSeekBar.setMax(mp.getDuration());
                                        int duration = mp.getDuration();
                                        if(duration==-1)
                                            view.audioDuration.setText("");
                                        else
                                            view.audioDuration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((int) duration), TimeUnit.MILLISECONDS.toSeconds((int) duration)));

                                        view.audioSeekBar.setOnTouchListener(new OnTouchListener() 
                                        {   
                                            @SuppressLint("ClickableViewAccessibility") @Override
                                            public boolean onTouch(View v, MotionEvent event) 
                                            {   
                                                if(mp.isPlaying())
                                                {
                                                    SeekBar audioSeekBar = (SeekBar)v;
                                                    mp.seekTo(audioSeekBar.getProgress());
                                                }
                                                return false;
                                            }
                                        });     
                                        view.imgAudioPlay.setOnClickListener(new View.OnClickListener()
                                        {
                                            public void onClick(View v)
                                            {
                                                if(isPlaying && !mp.isPlaying() && mp!=null){
                                                    mpG.pause();

                                                }
                                                if(mp.isPlaying() && mp!=null)
                                                {
                                                    mp.pause();
                                                    isPlaying = false;

                                                }
                                                else if(!mp.isPlaying())
                                                {
                                                    if(mp!=null)
                                                    {
                                                        try {
                                                            mp.setDataSource(activity,audioUri);    
                                                            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);   
                                                            mp.prepare();

                                                        } catch (IllegalStateException e) {
                                                            e.printStackTrace();
                                                        } catch (IOException e) {
                                                            e.printStackTrace();
                                                        }
                                                        mpG = mp;
                                                        isPlaying = true;
                                                        vhG = view;
                                                        mp.start(); 

                                                        timeElapsed = mp.getCurrentPosition();
                                                        view.audioSeekBar.setProgress((int) timeElapsed);                                            
                                                         durationHandler.postDelayed(runnableAudio, 100);
                                                         mp.setOnCompletionListener(new OnCompletionListener() {                                                
                                                            @Override
                                                            public void onCompletion(MediaPlayer mp) {
                                                                mp.seekTo(0);
                                                                mp.reset();
                                                                mp.stop();
                                                                isPlaying = false;

                                                                    durationHandler.removeCallbacks(runnableAudio);


                                                            }
                                                        });                                         
                                                    }
                                                }
                                            }
                                            });                                         
                                    }
                                            else
                                            {
                                                System.out.println("Audio Deleted! 1 ");
                                            }
                                        }
                                            catch(NullPointerException e)
                                            {
                                                System.out.println("null error : " + e.getMessage());
                                            }
                                        }
                                        else 
                                        {                                   }
                                    }
                                    else 
                                    {           System.out.println("Audio Deleted! 2");
                                    }
                                }                   
                    }
                catch(NullPointerException e)
                {
                } catch (IllegalArgumentException e1) {
                    e1.printStackTrace();
                } catch (SecurityException e1) {
                    e1.printStackTrace();
                } catch (IllegalStateException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if(activity.isChangingConfigurations())
                {
                    mp.stop();
                    mp.reset();
                }
                if (activity.isFinishing()){                
                    mp.stop();
                    mp.reset();
                }   
            }