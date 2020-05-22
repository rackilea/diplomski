public void playFile(String fileToPlay)
    {
     // see where we find a suitable autiotrack
        MediaExtractor extractor = new MediaExtractor();
        try
        {
            extractor.setDataSource(fileToPlay);
        }
        catch (IOException e)
        {
            out.release();
            return;
        }
   extractor.selectTrack(0);

    String fileType=typeForFile(fileToPlay);
    if (fileType==null)
    {
        out.release();
        extractor.release();
        return;
    }

    MediaCodec codec = MediaCodec.createDecoderByType(fileType);
    MediaFormat wantedFormat=extractor.getTrackFormat(0);
    codec.configure(wantedFormat,null,null,0);
    codec.start();

    ByteBuffer[] inputBuffers = codec.getInputBuffers();
    ByteBuffer[] outputBuffers = codec.getOutputBuffers();

    // Allocate our own buffer
    int maximumBufferSizeBytes = 0;
    for(ByteBuffer bb:outputBuffers)
    {
        int c=bb.capacity();
        if (c>maximumBufferSizeBytes) maximumBufferSizeBytes=c;
    }
    setupBufferSizes(maximumBufferSizeBytes/4);

    final MediaCodec.BufferInfo bufferInfo=new MediaCodec.BufferInfo();
    MediaFormat format=null;
    while(true)
    {
        long timeoutUs=1000000;
        int inputBufferIndex = codec.dequeueInputBuffer(timeoutUs);
        if (inputBufferIndex >= 0)
        {
            ByteBuffer targetBuffer = inputBuffers[inputBufferIndex];
            int read = extractor.readSampleData(targetBuffer, 0);
            int flags=extractor.getSampleFlags();
            if (read>0)
                codec.queueInputBuffer(inputBufferIndex, 0,read, 0, flags);
            else
                codec.queueInputBuffer(inputBufferIndex, 0, 0, 0, MediaCodec.BUFFER_FLAG_END_OF_STREAM);
            extractor.advance();
        }

        int outputBufferIndex = codec.dequeueOutputBuffer(bufferInfo,timeoutUs);
        if (outputBufferIndex >= 0)
        {
            final boolean last = bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM;

            int s=bufferInfo.size/4;
            ByteBuffer bytes=outputBuffers[outputBufferIndex];
            ((ByteBuffer)bytes.position(bufferInfo.offset)).asShortBuffer().get(shorts,0,s*2);
            process(shorts,0,s*2);

            codec.releaseOutputBuffer(outputBufferIndex, false);
            if (last)
                break;
        }
        else if (outputBufferIndex == MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED)
        {
            outputBuffers = codec.getOutputBuffers();
        }
        else if (outputBufferIndex == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED)
        {
            format = codec.getOutputFormat();
        }
    }

    extractor.release();
    codec.stop();
    codec.release();