public void onClick(View view) {
    Thread t = new Thread(){
                @Override
                public void run() {
                    Log.d("Audio", "Downloading all the audio for the chapter");

                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "Downloading all the audio for the chapter", Toast.LENGTH_SHORT).show();
                        }
                    });

                    final CountDownLatch latch = new CountDownLatch(chapters.get(groupPosition).getSubChapters().size());
                    Executor ex;

                    for (int child = 0; child < chapters.get(groupPosition).getSubChapters().size(); child++) {

                        String Language = "en";
                        String FileName = subChapters.get(chapters.get(group)).get(child).getAudio();

                        audioDownload = new AudioDownload(Course, FileName, Language, activity, latch);
                        audioDownload.setOnAudioDownloadFinishedListener(new AudioDownload.OnAudioDownloadFinishedListener() {
                            @Override
                            public void OnAudioDownloadThreadFinished(Boolean success) {
                                if (success) {
                                    activity.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(context, "Download was successful", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        });

                        ex = new Executor() {
                            @Override
                            public void execute(Runnable command) {
                                command.run();
                            }
                        };
                        ex.execute(audioDownload);
                    }

                    try{
                        latch.await();
                        Log.d("multipleAudioDownload", "all Threads are finished");
                        Toast.makeText(context, "Downloading was successful", Toast.LENGTH_SHORT).show();

                    }catch (InterruptedException e){
                        Log.e("multipleAudioDownload",e.getMessage());
                    }
                }
            };
            t.start();

        }