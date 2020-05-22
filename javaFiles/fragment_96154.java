avcodec.avcodec_register_all();
    avcodec.avcodec_init();
    avformat.av_register_all();

    /* find the H263 video encoder */
    mCodec = avcodec.avcodec_find_encoder(avcodec.CODEC_ID_H263);
    if (mCodec == null) {
        Log.d("TEST_VIDEO", "avcodec_find_encoder() run fail.");
    }

    mCodecCtx = avcodec.avcodec_alloc_context();
    picture = avcodec.avcodec_alloc_frame();

    /* put sample parameters */
    mCodecCtx.bit_rate(400000);
    /* resolution must be a multiple of two */
    mCodecCtx.width(VIDEO_WIDTH);
    mCodecCtx.height(VIDEO_HEIGHT);
    /* frames per second */
    AVRational avFPS = new AVRational();
    avFPS.num(1);
    avFPS.den(VIDEO_FPS);
    mCodecCtx.time_base(avFPS);
    mCodecCtx.pix_fmt(avutil.PIX_FMT_YUV420P);
    mCodecCtx.codec_id(avcodec.CODEC_ID_H263);
    mCodecCtx.codec_type(avutil.AVMEDIA_TYPE_VIDEO);

    /* open it */
    if (avcodec.avcodec_open(mCodecCtx, mCodec) < 0) {
        Log.d("TEST_VIDEO", "avcodec_open() run fail.");
    }

    /* alloc image and output buffer */
    output_buffer_size = 100000;
    output_buffer = avutil.av_malloc(output_buffer_size);

    size = mCodecCtx.width() * mCodecCtx.height();
    picture_buffer = avutil.av_malloc((size * 3) / 2); /* size for YUV 420 */

    picture.data(0, new BytePointer(picture_buffer));
    picture.data(1, picture.data(0).position(size));
    picture.data(2, picture.data(1).position(size / 4));
    picture.linesize(0, mCodecCtx.width());
    picture.linesize(1, mCodecCtx.width() / 2);
    picture.linesize(2, mCodecCtx.width() / 2);