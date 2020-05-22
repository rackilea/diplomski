//(1)Convert byte[] first
    byte[] data420 = new byte[data.length];
    convert_yuv422_to_yuv420(data, data420, VIDEO_WIDTH, VIDEO_HEIGHT);

    //(2) Fill picture buffer
    int data1_offset = VIDEO_HEIGHT * VIDEO_WIDTH;
    int data2_offset = data1_offset * 5 / 4;
    int pic_linesize_0 = picture.linesize(0);
    int pic_linesize_1 = picture.linesize(1);
    int pic_linesize_2 = picture.linesize(2);

    //Y
    for(y = 0; y < VIDEO_HEIGHT; y++) 
    {
        for(x = 0; x < VIDEO_WIDTH; x++) 
        {
            picture.data(0).put((y * pic_linesize_0 + x), data420[y * VIDEO_WIDTH + x]);
        }
    }

    //Cb and Cr
    for(y = 0; y < VIDEO_HEIGHT / 2; y++) {
        for(x = 0; x < VIDEO_WIDTH / 2; x++) {
            picture.data(1).put((y * pic_linesize_1 + x), data420[data1_offset + y * VIDEO_WIDTH / 2 + x]);
            picture.data(2).put((y * pic_linesize_2 + x), data420[data2_offset + y * VIDEO_WIDTH / 2 + x]);
        }
    }

    //(2)Encode
    //Encode the image into output_buffer
    out_size = avcodec.avcodec_encode_video(mCodecCtx, new BytePointer(output_buffer), output_buffer_size, picture);
    Log.d("TEST_VIDEO", "Encoded '" + out_size + "' bytes");

    //Delayed frames
    for(; out_size > 0; i++) {
        out_size = avcodec.avcodec_encode_video(mCodecCtx, new BytePointer(output_buffer), output_buffer_size, null);
        Log.d("TEST_VIDEO", "Encoded '" + out_size + "' bytes");
        //fwrite(output_buffer, 1, out_size, file);
    }