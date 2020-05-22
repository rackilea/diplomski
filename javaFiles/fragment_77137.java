while(av_read_frame(pFormatCtx, &packet)>=0) {
  // Is this a packet from the video stream?
  if(packet.stream_index==videoStream) {
    // Decode video frame
    avcodec_decode_video2(pCodecCtx, pFrame, &frameFinished, &packet);
    ...