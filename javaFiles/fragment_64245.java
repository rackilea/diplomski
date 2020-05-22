protected void startRecording() {
        try {
            mrec = new MediaRecorder();
            mCamera.unlock();
            mrec.setCamera(mCamera);

            //Set audio source
            mrec.setAudioSource(MediaRecorder.AudioSource.MIC);
            //set video source
            mrec.setVideoSource(MediaRecorder.VideoSource.CAMERA);

            //set output format
            mrec.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);

            int width = 320;
            int height = 240;
            try {
                //get the available sizes of the video
                List<Size> tmpList = getSupportedVideoSizes();

                final List<Size> sizeList = new Vector<Size>();

                // compare the apsect ratio of the candidate sizes against the
                // real ratio
                Double aspectRatio = (Double.valueOf(getWindowManager()
                        .getDefaultDisplay().getHeight()) / getWindowManager()
                        .getDefaultDisplay().getWidth());
                for (int i = tmpList.size() - 1; i > 0; i--) {
                    Double tmpRatio = Double.valueOf(tmpList.get(i).height)
                            / tmpList.get(i).width;
                    if (EnableLog.LOG_TAG) {
                        Log.e("Width & height", tmpList.get(i).width + " x "
                                + tmpList.get(i).height);
                    }
                    if (Math.abs(aspectRatio - tmpRatio) < .15) {
                        width = tmpList.get(i).width;
                        height = tmpList.get(i).height;
                        sizeList.add(tmpList.get(i));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // set the size of video.
            // If the size is not applicable then throw the media recorder stop
            // -19 error
            mrec.setVideoSize(width, height);

            // Set the video encoding bit rate this changes for the high, low.
            // medium quality devices
            mrec.setVideoEncodingBitRate(1700000);

            //Set the video frame rate
            mrec.setVideoFrameRate(30);

            //set audio encoder format
            mrec.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

            //set video encoder format
            mrec.setVideoEncoder(MediaRecorder.VideoEncoder.H264);

            //Show the display preview
            mrec.setPreviewDisplay(surfaceHolder.getSurface());

            //output file path
            mrec.setOutputFile(output_path);

            mrec.prepare();

            mrec.start();

        } catch (IllegalStateException e) {
            Crashlytics.logException(e);
            e.printStackTrace();
        } catch (IOException e) {
            Crashlytics.logException(e);
            e.printStackTrace();
        }
    }

public List<Size> getSupportedVideoSizes() {
        if (params.getSupportedVideoSizes() != null) {
            return params.getSupportedVideoSizes();
        } else {
            // Video sizes may be null, which indicates that all the supported
            // preview sizes are supported for video recording.
            return params.getSupportedPreviewSizes();
        }
    }