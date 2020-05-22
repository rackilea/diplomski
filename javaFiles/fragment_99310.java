mRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                mIsRecording = false;
                mIsTimelapse = false;

                // Starting the preview prior to stopping recording which should hopefully
                // resolve issues being seen in Samsung devices.

                try {
                    startPreview();
                    mMediaRecorder.stop();
                    mMediaRecorder.reset();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent mediaStoreUpdateIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                mediaStoreUpdateIntent.setData(Uri.fromFile(new File(mVideoFileName)));
                sendBroadcast(mediaStoreUpdateIntent);

                goNext();
            }
        });