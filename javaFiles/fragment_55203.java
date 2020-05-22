String outputFile = Environment.getExternalStorageDirectory().
                        getAbsolutePath() + "/rumor.mp3";
myRecorder = new MediaRecorder();
                myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                myRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
                myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
                myRecorder.setOutputFile(outputFile);