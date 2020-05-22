void close(){
        // Uncomment only if you know what you are doing
        try {
            localMediaStream.dispose();
            localMediaStream = null;
            if(videoCapturer!=null){
                videoCapturer.dispose();
            }
            videoCapturer = null;
            videoSource.stop(); //very important
        } catch (Exception e) {
            e.printStackTrace();
        }
    }