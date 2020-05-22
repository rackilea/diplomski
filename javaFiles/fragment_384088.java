public static void MergeMp3AndJpegIntoMp4(String path2ImageFile,String path2AudioFile, String path2OutputFile) throws IOException
    {

        IplImage ipl = cvLoadImage(path2ImageFile);
        int height = ipl.height();
        int width = ipl.width();
        if(height%2!=0) height = height+1;
        if(width%2!=0) width = width+1;

        OpenCVFrameConverter.ToIplImage grabberConverter = new OpenCVFrameConverter.ToIplImage();  
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(path2OutputFile,width,height); 
        FrameGrabber audioFileGrabber = new FFmpegFrameGrabber(path2AudioFile);
        try 
        {  
            audioFileGrabber.start();

            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264 );//AV_CODEC_ID_VORBIS
            recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);//AV_CODEC_ID_MP3 //AV_CODEC_ID_AAC

            recorder.setFormat("mp4");  
            recorder.setAudioChannels(2);
            recorder.start();  

            Frame frame = null;
            while ((frame = audioFileGrabber.grabFrame())!=null) 
            {   recorder.record(grabberConverter.convert(ipl));  
                recorder.record(frame);
            }

            recorder.stop();  
            audioFileGrabber.stop();
         }  
         catch (org.bytedeco.javacv.FrameRecorder.Exception e){  
           e.printStackTrace();  
           throw e;
         }  

    }